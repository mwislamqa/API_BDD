import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getRequestT {

	@Test
	public void getAPITest() {

		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.GET, "api/users/2");

		String body = response.getBody().prettyPrint();
		//System.out.println(body);
		Assert.assertEquals(response.statusCode(), 200);

		// String josonPath=response.jsonPath().get("data.id");
		JsonPath jsonpath = response.jsonPath();

		String email = jsonpath.get("data.email");
		Assert.assertEquals(email, "janet.weaver@reqres.in");
		
		int id = jsonpath.get("data.id");
		Assert.assertEquals(id, 2);
		
		String url =jsonpath.get("support.url");
		Assert.assertEquals(url, "https://reqres.in/#support-heading");

	}

}
