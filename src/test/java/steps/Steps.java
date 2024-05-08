package steps;

import java.util.Map;

import org.asynchttpclient.Request;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Steps {

	RequestSpecification request=null;
	
	Response response=null; 
	
	@Given("set the endpoint")
	public void set_the_endpoint() {
		RestAssured.baseURI="https://dev149503.service-now.com/api/now/table/incident";
		 
	}
	@And("add the auth")
	public void add_the_auth() {
		RestAssured.authentication=RestAssured.basic("admin","lMEjmH!4Q6h%");
		 
	}
	
	@When("send the request")
	public void send_request() {
		request=RestAssured.given().log().all();
		response=request.get();
	}
	@Then("validate the response")
	public void validate_the_response() {
		response.then().log().all().assertThat().statusCode(200);
	}
	
	@Then("add the query params as {string} and {string}")
	public void set_query_prams(String key,String value ) {
		request=RestAssured.given().log().all().queryParam(key, value);
	}
	
	@When("send the request with qp")
	public void send_the_request_with_qp() {
		
		response=request.get();
		
	
	}
	@When("add the query params")
	public void add_the_query_params(DataTable dt) {
		
		
		Map<String, String> mapvalues=dt.asMap();
		request=RestAssured.given().log().all().queryParams(mapvalues);
		
	
	}
}
