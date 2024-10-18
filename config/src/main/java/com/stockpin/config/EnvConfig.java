package com.stockpin.config;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnvConfig {
    @PostConstruct
    public void loadEnv() {
        Dotenv dotenv = Dotenv.load();
        System.setProperty("spring.cloud.config.server.git.uri", dotenv.get("GIT_URI"));
        System.setProperty("spring.cloud.config.server.git.username", dotenv.get("GIT_USERNAME"));
        System.setProperty("spring.cloud.config.server.git.password", dotenv.get("GIT_PASSWORD"));
        System.setProperty("eureka.client.service-url.defaultZone", dotenv.get("EUREKA_DEFAULT_ZONE"));
    }
}
