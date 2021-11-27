package br.com.eduardobpwj.microservice.floriculture.store;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;


@EnableFeignClients
@EnableCircuitBreaker
@SpringBootApplication
@EnableResourceServer
public class StoreApplication {

    @Bean
    public RequestInterceptor getAuthenticatorInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                if (authentication == null)
                    return;
                OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
                String tokenValue = details.getTokenValue();
                requestTemplate.header("Authorization", "Bearer" + tokenValue);
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
    }

}
