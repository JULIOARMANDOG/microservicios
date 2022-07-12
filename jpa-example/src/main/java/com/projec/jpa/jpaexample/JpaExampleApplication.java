package com.projec.jpa.jpaexample;

import com.projec.jpa.jpaexample.data.User;
import com.projec.jpa.jpaexample.repository.RoleRepository;
import com.projec.jpa.jpaexample.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class JpaExampleApplication {

	@Autowired
	private UserRepository userRepository;


	@Autowired
	private RoleRepository roleRepository;


	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}



	private static final Logger log=LoggerFactory.getLogger(JpaExampleApplication.class);



	public static void main(String[] args) {
		SpringApplication.run(JpaExampleApplication.class, args);
	}


	@Bean
	public CommandLineRunner demo(UserRepository respository){
		return(args)->{

			log.info("Customer found with find all");
			for(User user: respository.findAll()){
				//log.info(user.getUsername().toString());
				log.info(user.getUsername()+user.getPassword() + user.getEmail()  );
			}
			log.info("");

		};
	}




}
