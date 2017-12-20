package com.yunbao.security.app.config.token;

import com.yunbao.security.core.property.SecurityProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;


/**
 * token 的生成方式 使用redis 进行token 的存储
 */
@Configuration
public class TokenConfig {
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;


    @Bean
    public TokenStore JwTToken(){
        return new RedisTokenStore(redisConnectionFactory);
    }


    @Autowired
    SecurityProperty securityProperty;
    /**
     * jwt 格式生成器
     * @return
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey(securityProperty.getAppSecurityProperty().getClient().getJwtkey());
        return jwtAccessTokenConverter;
    }

}
