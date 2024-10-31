package utils;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerData {
	
	public static void name() {
	Faker faker = new Faker();
	
	String fName=faker.name().fullName();
	
	}
	
//@Test	
public static void Data() {
		
		
		Faker faker = new Faker();
		System.out.println("------------------------");
		String fName=faker.name().fullName();
		System.out.println("full Name   :"+fName);
		String streetName = faker.address().streetName();
		System.out.println("address  :"+streetName);
		String number = faker.address().buildingNumber();
		System.out.println("Buildeing N0  :"+number);
		String city = faker.address().city();
		System.out.println("city  :"+city);
		String country = faker.address().country();
		System.out.println("country  :"+country);
		String zcode=faker.address().zipCode();
		System.out.println("zip  :"+zcode);
		String email=faker.internet().emailAddress();
		System.out.println("email  :"+email);
		System.out.println("-------------------------");
		

	}


}
