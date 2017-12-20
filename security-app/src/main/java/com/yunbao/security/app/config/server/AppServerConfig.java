package com.yunbao.security.app.config.server;


import com.yunbao.security.core.property.OAuth2Client;
import com.yunbao.security.core.property.SecurityProperty;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Configuration
@EnableAuthorizationServer
public class AppServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;


    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private SecurityProperty securityConfig;
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore).authenticationManager(authenticationManager)
                .accessTokenConverter(jwtAccessTokenConverter);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
       security.tokenKeyAccess("isAuthenticated"); //解密的key
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        InMemoryClientDetailsServiceBuilder builder = clients.inMemory();
        if (ArrayUtils.isNotEmpty(securityConfig.getAppSecurityProperty().getClient().getAuth2Clients())){
            for (OAuth2Client auth2Client:securityConfig.getAppSecurityProperty().getClient().getAuth2Clients()
                 ) {
                builder.withClient(auth2Client.getClientId())
                        .secret(auth2Client.getClientSecret())
                        .accessTokenValiditySeconds(auth2Client.getAccessTokenValiditySeconds())
                        .refreshTokenValiditySeconds(auth2Client.getRefreshTokenValiditySeconds())
                        .authorizedGrantTypes("refresh_token", "password")
                        .scopes("all", "write");

            }

        }
    }
}

