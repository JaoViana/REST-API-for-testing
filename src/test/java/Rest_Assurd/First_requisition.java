package Rest_Assurd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class First_requisition {
	
	@Test
	public void test_get() {
		
		baseURI = "http://localhost:3000";
		given().
			param("name", "Automation");
			get("/subjects").
		then().
			statusCode(200).
			log().all();
		
	}
	
	@Test
	
	public void test_post() {
		
		JSONObject request = new JSONObject();
		request.put("firstName","Tom");
		request.put("lastName", "Cooper");
		request.put("subjectID", 1);
		
		baseURI = "http://localhost:3000/";
		
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();
				
	}
	
	@Test
	public void test_patch() {
		
		JSONObject request = new JSONObject();
		
		request.put("lastName","Ramos");
		
		baseURI = "http://localhost:3000";
		

		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(request.toJSONString()).
		when().
			patch("/users/3").
		then().
			statusCode(200).
			log().all();
						
	}
	
	@Test
	public void test_put() {
		
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Justo");
		request.put("lastName", "Pinheiro");
		request.put("subjectID", "1");
		
		baseURI = "http://localhost:3000";
		

		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(request.toJSONString()).
		when().
			put("/users/3").
		then().
			statusCode(200).
			log().all();
		
		
	}
	
	@Test
	public void test_delete() {
		
		baseURI = "http://localhost:3000";
		
		when().
			delete("/users/4").
		then().	
			statusCode(200);
		
	}
	
}
