package postMethod;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.FakerData;

public class PostRequest {
	
	String tokenG;
	
	Faker faker = new Faker();
	
	
	@Test(enabled=false)
	public void postMethodTest() {
		
		
		Faker faker = new Faker();
		HashMap<String,Object> map = new HashMap<String,Object>();

		// map.put("name", "morpheus");
		// map.put("job", "leader");
		//String fullName = faker.name().fullName();
		map.put("name", "Md islam");
		map.put("job", faker.job().title());
		RestAssured.baseURI = "https://reqres.in/";
		RestAssured.basePath = "/api/users";

		
		RestAssured.given()
	.contentType("application/json; charset=utf-8")
		.log()
		.all()
		.body(map)
		.when()
		.post()
		.then()
			.statusCode(201)
			//.and().assertThat().body("name", equals(""))
			.log()
			.all()
			.extract().body().asPrettyString();
			
		//Assert.assertEquals(map.name, "Elroy Dickens");
		
	}
	@BeforeTest(enabled= true)
	public void tokenGenerate() {
	tokenG = "3bc87675be6f4adc53980d0eed71e9c7b3a34d093e20f989829de46b5a8c0d6a";

	}
	
	@Test(enabled=true)
	public void bererToken() {

		String url = "https://gorest.co.in/public/v2/users";

		// create payload
		JSONObject js = new JSONObject();
		js.put("name", faker.name().fullName());
		js.put("gender", "male");
		js.put("email", faker.internet().emailAddress());
		js.put("status","active");

		String payload = js.toJSONString();

		String token = tokenG;
		String name = "Bearer ";
		String auth = name + token;
		// call api
		RequestSpecification restSp = RestAssured.given()
				.header("Authorization", auth)
				.contentType("application/json")
				.body(payload);
		Response response = restSp.post(url);
		int code = response.getStatusCode();
		System.out.println(code);
		String resBody = response.body().prettyPrint();
		//String res=response.body().toString();
		//Assert.assertTrue(res.contains(res),"Md Islam");
	//	boolean pesponse= resBody.contentEquals("male");
	//	Assert.assertTrue(pesponse, "male");
		System.out.println(resBody);

	}


}
