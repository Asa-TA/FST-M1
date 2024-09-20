package Activities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import java.util.HashMap;
import java.util.Map;

public class Spec_test {
	RequestSpecification requestSpec;
	ResponseSpecification ResponseSpec;
	int petID;
	
	@BeforeClass
	public void init() {
		requestSpec =new RequestSpecBuilder().
				setBaseUri("https://petstore.swagger.io/v2/pet").
				addHeader("Content-Type", "application/json").build();
		ResponseSpec=new ResponseSpecBuilder().expectStatusCode(200)
				.expectResponseTime(lessThanOrEqualTo(3000L)).build();
	}
	@Test(priority = 1)
	public void postRequest() {
		Map<String,Object> request=new HashMap<String,Object>();
		request.put("id", 13542);
		request.put("name", "Mypet");
		request.put("status", "alive");
		Response resp=given().spec(requestSpec).body(request).when().post();
		System.out.println("Response by Pritty "+resp.getBody().asPrettyString());
		petID=resp.then().extract().path("id");
		System.out.println("petId is "+petID);
		resp.then().spec(ResponseSpec).body("status", equalTo("alive")).log().all();
		System.out.println("pet is created");
	}
	@Test(priority = 2)
	public void getRequest() {
		
		given().spec(requestSpec).pathParam("petId", petID).log().uri()
		.when().get("{/petId}")
		.then().spec(ResponseSpec).body("status", equalTo("alive")).log().all();
		System.out.println("Pet details");
		
	}
	@Test(priority = 3)
	public void deleteRequest() {
		
		given().spec(requestSpec).pathParam("petId", petID).log().all()
		.when().delete("{/petId}")
		.then().spec(ResponseSpec).body("status", equalTo(""+petID)).log().all();
		System.out.println("pet - deleted");
	}
}

