package com.redasp.pma.springexample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManifactureConfig {
	
	@Bean
	public Car newCar()
	{
		Engine e = new Engine();
		Doors d = new Doors();
		Tires t = new Tires();
		
		return new Car(e,t,d);
	}
	
	

}
