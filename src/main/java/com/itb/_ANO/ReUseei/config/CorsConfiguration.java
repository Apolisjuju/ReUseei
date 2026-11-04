package com.itb._ANO.ReUseei.config; // 1. Garanta que esta linha seja a primeira do arquivo

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer; // 2. Importação correta

@Configuration
public class CorsConfiguration implements WebMvcConfigurer { // 3. 'W' maiúsculo em WebMvcConfigurer

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8686", "http://localhost:5173", "http://localhost:5174", "http://localhost:8080") // Coloque aqui as URLs do seu front-end (ex: React, Vue, Vite, etc.)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
