package com.example.dine_in_order_api.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "app")
public class AppEnv {
    private String baseUrl;
    private Cloudinary cloudinary;

    @Getter
    @Setter
    public static class Cloudinary {
        private String apiKey;
        private String apiSecret;
        private String cloudName;
    }
}
