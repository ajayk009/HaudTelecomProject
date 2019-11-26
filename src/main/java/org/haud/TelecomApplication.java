package org.haud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EntityScan(basePackages="org.haud.model")
@EnableJpaRepositories(basePackages="org.haud.repository")
public class TelecomApplication
{

	public static void main(String[] args) {
		SpringApplication.run(TelecomApplication.class, args);
	}


}
