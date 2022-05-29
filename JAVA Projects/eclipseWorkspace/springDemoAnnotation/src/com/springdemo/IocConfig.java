package com.springdemo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@Configuration
@ComponentScan("com.springdemo")
@PropertySource("classpath:values.properties")
public class IocConfig {

	
	
	@Bean
	public ICustomerDal database() {
		return new CustomerDal();
	}
	

	@Bean
	public ICustomerService service() {
		return new CustomerManager(database());
	}
}
