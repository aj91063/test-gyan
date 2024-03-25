package org.test.gyan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("org.test.gyan.repositry")
@EntityScan("org.test.gyan.model")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class TestGyanApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestGyanApplication.class, args);
	}

}
