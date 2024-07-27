package com.vti.blog_app;

import com.vti.blog_app.entity.User;
import com.vti.blog_app.mapper.UserMapper;
import com.vti.blog_app.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@AllArgsConstructor
public class BlogAppApplication implements CommandLineRunner {

	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(BlogAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var user = new User();
		user.setName("Vo Quang Thong");
		user.setUsername("thong02");
		user.setEmail("thong02@gmail.com");

		var encodedPassword = passwordEncoder.encode("123456Q");
		user.setPassword(encodedPassword);
		user.setRole(User.Role.ADMIN);
		userRepository.save(user);
	}
	@Bean
	public WebMvcConfigurer webMvcConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("*") // http://127.0.0.1:5500
						.allowedMethods("HEAD", "OPTIONS", "GET", "POST", "PUT", "PATCH", "DELETE");
			}
		};
	}
}
