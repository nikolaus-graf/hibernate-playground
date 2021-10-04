package org.graf.hibernateplayground;

import org.graf.hibernateplayground.service.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HibernatePlaygroundApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(HibernatePlaygroundApplication.class, args);
		PersonService personService = applicationContext.getBean(PersonService.class);
		personService.removeAddressFromPerson();
	}
}
