package com.daltahir.mutant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class MutantApplication {

	@Configuration
	public class JacksonConfiguration {

	    @Bean
	    public ObjectMapper objectMapper() {
	        return new ObjectMapper()
	                .enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT )
	                .enable(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY );
	    }
	}
	public static void main(String[] args) {
		SpringApplication.run(MutantApplication.class, args);
	}

}
