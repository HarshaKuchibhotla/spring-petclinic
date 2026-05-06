package org.springframework.samples.petclinic;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

public class MyApiTest {

	@Test
	public void testGetOwners() {
		String baseUrl = System.getenv().getOrDefault("baseUrl", "http://app:8080");
		RestAssured.baseURI = baseUrl;

		RestAssured.given().when().get("/owners/find").then().statusCode(200);
	}

}