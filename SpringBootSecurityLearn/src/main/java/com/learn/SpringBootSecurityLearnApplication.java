package com.learn;

import com.Models.User;
import com.repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ComponentScan("com")
@SpringBootApplication

public class SpringBootSecurityLearnApplication implements CommandLineRunner {

	@Autowired(required = false)
	private UserRepository userrepository;

	@Autowired(required = false)
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityLearnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User user = new User();
		user.setEmail("usha@gmail.com");
		user.setUsername("usha");
		user.setPassword(this.bCryptPasswordEncoder.encode("rani"));
		user.setRole("NORMAL");

		this.userrepository.save(user);

		User user1 = new User();
		user1.setEmail("Ashok@gmail.com");
		user1.setUsername("Ashok");
		user1.setPassword(this.bCryptPasswordEncoder.encode("kumar"));
		user1.setRole("ADMIN");

		this.userrepository.save(user1);
	}

}