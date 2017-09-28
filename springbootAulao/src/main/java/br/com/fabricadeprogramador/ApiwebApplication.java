package br.com.fabricadeprogramador;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.Data;



@SpringBootApplication
public class ApiwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiwebApplication.class, args);
	}
}

@Entity//achar erro
@Data class cliente{
	
	@Id
	private Integer id;
	
	private String nome;
}