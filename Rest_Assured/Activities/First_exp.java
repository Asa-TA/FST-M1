package Activities;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;

public class First_exp {
	@Test
	public void getRequestWithQueryParameter() {
		
		Response resp=given()
					.baseUri("https://petstore.swagger.io/v2/pet")
					.header("Content-type","application/json")
					.queryParam("status", "alive")
					.when().get("/findByStatus");
		System.out.println("Response by string "+resp.getBody().asString());
		System.out.println("Response by Pritty "+resp.getBody().asPrettyString());
		String statis=resp.then().extract().path("[0].status");
		System.out.println("Status is "+statis);
		Assert.assertEquals(statis, "alive");
		resp.then().statusCode(200);
	}
	@Test
	public void getRequestWithPathParameter() {
		
		given()
				.baseUri("https://petstore.swagger.io/v2/pet")
					.header("Content-type","application/json")
					.pathParam("petId", 77232)
					.log().all()
				.when().get("/{petId}")
			.then().statusCode(200)
			.log().all()
			.body("status", equalTo("alive")).
			body("[0].name", equalTo("Riley"));
	}

}