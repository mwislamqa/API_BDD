package putMehod;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PutRequest {

	public static HashMap map = new HashMap();

	@BeforeClass
	public void putData() {
		map.put("name", "morpheus");
		map.put("salary", "45");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath = "/update/21";
	}

	@Test
	public void postTest() {
		RestAssured
		.given()
		.contentType("application/json")
		.body(map).when()
		.put()
		.then()
		.statusCode(200);

	}

}
