package stepdefnition_scoutline;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class scenari_outline {
RequestSpecification request=null;
	
	Response response=null; 
	
	@Given("set the endpoint")
	public void setTheEndpoint() {
		RestAssured.baseURI="https://dev149503.service-now.com/api/now/table/incident";
	}
	@Given("add the auth")
	public void addTheAuth() {
		RestAssured.authentication=RestAssured.basic("admin","lMEjmH!4Q6h%");
		
	}

	@When("send the request")
	public void sendRequest() {
		request = RestAssured.given().log().all();
		response = request.get();
	}
	
	@Given("add the query params as {string} and {string}")
	public void addTheQueryParamsAsAnd(String key1, String value1) {
	
		request=RestAssured.given().log().all().queryParam(key1, value1).contentType(ContentType.JSON);
	   
	}
	@When("when post request with short description as {string},and catagery as {string}")
	public void when_post_request_with_short_description(String short_desc,String category) {
	    response = request.body("{\"short_description\":\""+short_desc+"\",\"category\":\""+category+"\"}").post();
	}
	@Then("validate the response {int}")
	public void validateTheResponse(int code) {
		response.then().log().all().assertThat().statusCode(code);
	}
}
