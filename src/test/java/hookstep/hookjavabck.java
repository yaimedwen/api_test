package hookstep;

import java.util.*;

import org.hamcrest.Matchers;
import org.hamcrest.core.StringContains;

import com.google.common.collect.Multiset.Entry;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class hookjavabck {
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


@Given("add the query params as {string} and {string}")
public void addTheQueryParamsAsAnd(String string, String string2) {
	request=RestAssured.given().log().all().queryParam(string, string2).contentType(ContentType.JSON);
}

@When("send the request with qp")
public void sendTheRequestWithQp() {
	request=RestAssured.given().log().all();
	response=request.get();

}

@Then("validate the response")
public void validateTheResponse() {
  response.then().log().all().assertThat().statusCode(200);
}

@Then("validate the response as below")
public void validateTheResponse(DataTable dt) {
    Map<String, String> asmap=dt.asMap();
    
    for (java.util.Map.Entry<String,String> eachentry : asmap.entrySet()) {
    	
    	response.then().body(eachentry.getKey(), Matchers.equalTo(eachentry.getValue()));
		
	}
}
}
