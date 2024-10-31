import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Api_rest {
	
	
	@Test
	void postRequest() {

		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification httpReques = RestAssured.given();
		// request payload alonn wiht post request
		// public class JSONObject extends java.lang.Object.
		// A JSONObject is an unordered collection of name/value pairs.
		JSONObject requesParams = new JSONObject();

		requesParams.put("name", "morpheus");
		requesParams.put("job", "leader");

		httpReques.header("Contain-Type", "application/json");
		httpReques.header("time", "10:11");

		httpReques.body(requesParams.toJSONString());// attached above data

		// response object
		Response response = httpReques.request(Method.POST, "/api/users");

		String responsebody = response.getBody().asPrettyString();
		System.out.println("response body is::::" + responsebody);
		int statusCode = response.getStatusCode();
		System.out.println("Succes code is::" + statusCode);
		Assert.assertEquals(statusCode, 201);
		Assert.assertEquals(responsebody.contains("id"), true);

		/*
		 * String josonPath=response.jsonPath().get("id");
		 * 
		 * Assert.assertEquals(josonPath, "176");
		 *
		 */
		// verify api header all contains
		// succes code
		// verifying sucess line
		// verifying body contains
		// response body
		// response time

	}


}
