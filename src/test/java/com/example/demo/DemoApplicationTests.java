package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


//@SpringBootTest
//not needed because we only test the JPA slice, not full app

//@AutoConfigureTestDatabase
//not needed because already @DataJpaTest configures embedded database

@ExtendWith(SpringExtension.class)
@DataJpaTest
class DemoApplicationTests {

	@Autowired
	PersonaRepository rep;
	
	@Test
	void contextLoads() {
	
		Person p1 = new Person(1L, "angel");
		rep.save(p1);
		
		List<Person> all = rep.findAll();
		assertEquals(1, all.size());
		
	}

}
