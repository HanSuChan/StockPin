package com.hsc.loadbalancer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NettyConfig {

    // yml 파일에서 server.port 값을 주입받음
    @Value("${server.port:19999}")  // 기본값 설정 가능
    private int port;

    @Bean
    public WebServerFactoryCustomizer<NettyReactiveWebServerFactory> nettyCustomizer() {
        return factory -> factory.setPort(port);  // Netty 서버의 포트 설정
    }
}
