package getMethod;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.* ;

public class GetMethod2 {
	
	@Test
	public void getAssert() {
		
	String response=	given().contentType(ContentType.JSON)
		.when()
			.get("https://reqres.in/api/users")
			.getBody().asPrettyString();
	
			
		
		//.extract().body().prityPrint()
		/*.then()
			.statusCode(200)
			.header("Content-Type", "application/json; charset=utf-8");
			*/
			
		
		System.out.println(response);
			
			
	
		
		
		
		
	}

}
