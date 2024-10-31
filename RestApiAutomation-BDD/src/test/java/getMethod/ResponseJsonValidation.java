package getMethod;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ResponseJsonValidation {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
	
	
		String resBody ="{\r\n" + 
				"    \"name\": \"morpheus\",\r\n" + 
				"    \"job\": \"leader\",\r\n" + 
				"    \"id\": \"696\",\r\n" + 
				"    \"createdAt\": \"2023-12-11T00:21:48.275Z\"\r\n" + 
				"}";
	
	ObjectMapper obj = new ObjectMapper() ;
	
	Person person=obj.readValue(resBody, Person.class);
	System.out.println("id" + person.getId());
	
	}

}
