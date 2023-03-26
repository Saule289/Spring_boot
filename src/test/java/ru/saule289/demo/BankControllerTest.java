package ru.saule289.demo;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.saule289.demo.domain.UserInfo;

import static io.restassured.RestAssured.with;


public class BankControllerTest {


	private RequestSpecification requestSpec = with()
			.baseUri("http://localhost:8080/");

	@Test
	void bankControllerTest() {
		requestSpec.get("user/getAll")
				.then()
				.statusCode(200)
				.extract()
				.response()
				.as(UserInfo[].class);


	}

}
