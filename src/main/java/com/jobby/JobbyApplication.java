package com.jobby;

import com.jobby.core.models.dtos.EnderecoDto;
import com.jobby.core.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JobbyApplication {

	@Autowired
	EnderecoService service;
	public static void main(String[] args) {
		SpringApplication.run(JobbyApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo() {
		return (args) -> {
			var enderecoDto = EnderecoDto.builder()
					.id(41)
					.cep("22031000")
					.numero("10")
					.complemento("casa 1")
					.build();

			var result = service.findEndereco(enderecoDto);

			System.out.println(result);
		};
	}
}
