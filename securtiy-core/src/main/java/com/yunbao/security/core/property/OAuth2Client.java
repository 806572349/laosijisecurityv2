package com.yunbao.security.core.property;

import lombok.Data;
@Data
public class OAuth2Client {
    private String clientId;
    private String clientSecret;
    private Integer accessTokenValiditySeconds;
    private Integer refreshTokenValiditySeconds;


}
