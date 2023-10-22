package com.example.excercise.Content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContentConfig {
    @Bean
    CommandLineRunner commandLineRunnerContent(){
        return args -> {};
    }
}
