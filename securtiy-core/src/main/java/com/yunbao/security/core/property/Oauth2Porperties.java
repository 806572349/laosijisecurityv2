package com.yunbao.security.core.property;

import lombok.Data;
@Data
public class Oauth2Porperties {
    private OAuth2Client[] auth2Clients = {};
    private String jwtkey = "yb";  //默认

}