package Restproject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import au.com.dius.pact.core.model.annotations.PactFolder;
import au.com.dius.pact.provider.junit.Provider;

@Provider("UserProvider")
@PactFolder("target/pacts")
public class Consumertest {
	
Map<String, String>header=new HashMap<String, String>();
	
	//Create pact contract
	@Pact(consumer = "UserConsumer", provider = "UserProvider")
	public RequestResponsePact createPact(PactDslWithProvider buider) {
		
		header.put("Content-Type", "Application/json");
		
		DslPart requestAndRespnse= new PactDslJsonBody().
				numberType("id",999).
				stringType("firstName","Asa").
				stringType("LastName","Test").
				stringType("Email","testrestassured@gamil.com");
			//create contract
		return buider.given("POST Request").
				uponReceiving("Request to create user").
				method("POST").
				headers(header).
				path("/api/user").body(requestAndRespnse).
				willRespondWith().status(201).body(requestAndRespnse).toPact();
	}
	
	@Test
	@PactTestFor(providerName = "UserProvider",port = "8282")
	public void postRequestTest() {
		Map<String, Object> request=new HashMap<String, Object>();
		request.put("id", "012");
		request.put("firstName", "Asa");
		request.put("LastName", "Test");
		request.put("Email", "testrestassured@gamil.com");
		
		given().baseUri("http://localhost:8282/api/users").
		headers(header).body(request).log().all()
		.when().post().then().statusCode(201)
		.body("id", equalTo(999)).log().all();
	}

}
