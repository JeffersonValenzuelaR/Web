package pe.edu.upc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@SpringBootApplication

public class Application implements CommandLineRunner{
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;
	public void run(String... args) throws Exception {
		 String password = "web";

	        for (int i = 0; i < 1; i++) {
	            String bcryptPassword = passwordEncoder.encode(password);
	            System.out.println(bcryptPassword);
	        }
    }
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
