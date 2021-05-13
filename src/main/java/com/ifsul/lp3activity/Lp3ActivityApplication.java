package com.ifsul.lp3activity;

import java.util.List;
import java.util.Optional;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Lp3ActivityApplication {
	
	@Autowired
	public UserRepository userRepository;
		
	@Autowired
	public CarRepository carRepository;

	public static void main(String[] args) {
		SpringApplicationBuilder sab = new SpringApplicationBuilder(Lp3ActivityApplication.class);
		sab.headless(false).run(args);
	}
	
	
	@Bean
	public UserRepository run(UserRepository ur, CarRepository cr) {
		
//		MainFrame mf = new MainFrame(ur);
		ListFrame lf = new ListFrame(ur, cr);
		
//		User user = new User();
//		user.setUsername("paolatunis");
//		user.setEmail("paolatunis@gmail.com");
//		user.setPassword("teste");
//		user.setFirstName("Paola");
//		user.setLastName("Tunis");
//		repo.save(user);
		
		
//		List<User> lista = repo.findAll();
//		for(User u : lista) {
//			System.out.println(u.getFirstName());
//		}
		
		
//		Optional<User> opt = repo.findById(1);
//		if(!opt.isEmpty()) {
//			User user = opt.get();
//			System.out.println(user.getFirstName());
//		};
		
//		repo.deleteById(1);
		
		return ur;
	}
	

}
