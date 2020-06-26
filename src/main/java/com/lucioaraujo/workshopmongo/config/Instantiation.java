package com.lucioaraujo.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.lucioaraujo.workshopmongo.domain.Post;
import com.lucioaraujo.workshopmongo.domain.User;
import com.lucioaraujo.workshopmongo.repository.PostRepository;
import com.lucioaraujo.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("30/05/2020"), "Partiu Viagem!", "Vou Viajar para o Canadá. Abraços!", maria);
		Post post2 = new Post(null, sdf.parse("02/06/2020"), "Cheguei!", "Canadá, meu novo lar!", maria);
		
		postRepository.saveAll(Arrays.asList(post1, post2));
	}
}
