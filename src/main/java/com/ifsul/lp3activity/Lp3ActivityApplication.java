package com.ifsul.lp3activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Lp3ActivityApplication {
	
	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	public SortOptionRepository sortOptionRepository;
	
	@Autowired
	public PreferenceRepository preferenceRepository;

	public static void main(String[] args) {
		SpringApplication.run(Lp3ActivityApplication.class, args);
	}
	
	//TODO: adicionar repositories
	// adicionar um query method pra cada repository
	// criar interface grafica
	// cadastrar entidades pela interface grafica
	// listar registros armazenados no banco pela interface grafica
	// executar os query methods mostrando pela interface grafica

}
