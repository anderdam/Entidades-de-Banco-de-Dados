package com.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.bind.ValidationException;

@SpringBootApplication
public class SpringChallengeApplication {

	public static void main(String[] args) {
		/*EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("challenge");
		EntityManager entityManager = entityManagerFactory.createEntityManager();*/
		SpringApplication.run(SpringChallengeApplication.class, args);
		/*entityManager.close();
		entityManagerFactory.close();*/
	}
}
