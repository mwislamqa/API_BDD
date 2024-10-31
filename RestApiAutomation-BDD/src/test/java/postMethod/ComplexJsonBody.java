package postMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;

public class ComplexJsonBody {

	public static void main(String[] args) {
		Faker fakeData = new Faker();

		List<Map<String, Object>> requerstBody = new ArrayList<Map<String, Object>>();

		HashMap<String, Object> data = new LinkedHashMap<String, Object>();
		data.put("id", 1);
		data.put("email", fakeData.internet().emailAddress());
		data.put("firsName", fakeData.name().fullName());
		data.put("age", 30);
		List<String> mobile = new ArrayList<String>();
		mobile.add("12345677");
		mobile.add("939393939");
		data.put("mobile", mobile);

		requerstBody.add(data);
		Map<String, Object> support = new LinkedHashMap<String, Object>();
		support.put("url", "www.google.co ");
		support.put("text", "i love code");

		requerstBody.add(support);
		RestAssured.given().log().all().body(requerstBody).get();

	}

}
