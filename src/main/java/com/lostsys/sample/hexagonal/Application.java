package com.lostsys.sample.hexagonal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
@Configuration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }    
   
    @Bean
    public RedisTemplate<String, String> redisTemplate( RedisConnectionFactory connectionFactory ) {
        RedisTemplate<String, String> template = new RedisTemplate<>();
        template.setConnectionFactory( connectionFactory );
        return template;
    }    

}
