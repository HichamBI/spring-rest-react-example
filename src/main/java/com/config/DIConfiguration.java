/*
 * Created by Hicham B.I.
 */

package com.config;

import com.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DIConfiguration {
    @Bean
    public UserService getUserService(){
        return new UserService();
    }
}