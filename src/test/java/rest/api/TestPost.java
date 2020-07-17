package rest.api;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class TestPost {
	
	@Test
	public void test_1_post() {
		
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("name", "Artur");
			map.put("job", "QA");

			System.out.println(map);
			
			JSONObject request = new JSONObject(map);
			
			System.out.println(request);
			System.out.println(request.toJSONString());
			
			given().
				header("Content-Type", "application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
						
				body(request.toJSONString()).
			when().
				post("https://reqres.in/api/users").
			then().
				statusCode(201);
			
			
	}


}
