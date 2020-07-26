package com.ncs.springcloud;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
public class InMemoryTokenStoreConfig {

    @Bean
    public InMemoryTokenStore getInMemoryTokenStore(){
        return new InMemoryTokenStore();
    }

}
