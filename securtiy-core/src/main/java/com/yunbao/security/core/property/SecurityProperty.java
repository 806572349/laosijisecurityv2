package com.yunbao.security.core.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@ConfigurationProperties(prefix = "yunbao.security")
public class SecurityProperty {
    private  AppSecurityProperty appSecurityProperty;

}
