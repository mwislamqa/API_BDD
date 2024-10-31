import static io.restassured.RestAssured.*;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;

public class StaticImport {

	public static void main(String[] args) {
		given()
		.when()
		.get("https://reqres.in/api/users")
	
				//.extract().body().prityPrint()
				.then()
				.statusCode(200)
				.header("Content-Type", "application/json; charset=utf-8")
				.log()
				.all();
				
		

	}

}
