package br.com.testePratico.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig { //configurar o ModelMapper no spring
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
