package com.finances.wallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class WalletApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(WalletApplication.class, args);
		context.start();
	}	
}
