package oneline.shop.db.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SchemaCreationTest {

	static EntityManagerFactory EMF;
	
	@BeforeAll
	static void init() {
		EMF = Persistence.createEntityManagerFactory("shopDS");
	}
	
	@Test
	void demo() {
		System.out.println("Dummy Test");
	}
	
	@AfterAll
	static void shutDown() {
		if(null != EMF)
			EMF.close();
	}
}
