package org.haud.configuration;

import org.haud.service.CustomerService;
import org.haud.service.SimCardService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;



@Profile("test")
@Configuration
public class TestConfiguration {

	@Bean
	@Primary
	public CustomerService customerService() {
		return Mockito.mock(CustomerService.class);
	}
	
	@Bean
	@Primary
	public SimCardService simCardService() {
		return Mockito.mock(SimCardService.class);
	}
}
