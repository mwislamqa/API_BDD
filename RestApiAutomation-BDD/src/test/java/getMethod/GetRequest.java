package getMethod;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetRequest {
	
	@Test
	public void getMethodTest() {
	
		given()
		.when()
		.get("https://reqres.in/api/users")
		.then().statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.header("Content-Type", "application/json; charset=utf-8")
		
		.log()
		.all();
		
	}

}
