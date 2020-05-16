package com.covid;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
 
import java.math.BigDecimal;

@SpringBootApplication
public class StartCovidApplication {

    // start everything
    public static void main(String[] args) {
        SpringApplication.run(StartCovidApplication.class, args);
    }

    // run this only on profile 'demo', avoid run this in test
	/* */
}