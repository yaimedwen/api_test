package products;

import java.io.File;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Product {
//	  RequestSpecification request = null;
//	    Response response = null;
	
	@Given("good")
	public void good(){
		File jsontest=new File("test.json");
	//RestAssured.baseURI = "https://fakestoreapi.com";
 // RestAssured.authentication=RestAssured.basic("admin","lMEjmH!4Q6h%");
	
 RestAssured.given().baseUri("https://fakestoreapi.com").get("/products").prettyPrint();
 
 System.out.println("-------------------------------------------------------------------------------");
 
 RestAssured.given().baseUri("https://fakestoreapi.com").header("Content-Type", "application/json").body(jsontest).when().put("/products/7").prettyPrint();
 
 

 
 
// ("{\n" +
//          "    \"title\": \"test product\",\n" +
//          "    \"price\": 13.5,\n" +
//          "    \"description\": \"lorem ipsum set\",\n" +
//          "    \"image\": \"https://i.pravatar.cc\",\n" +
//          "    \"category\": \"electronic\"\n" +
//          "}")
//  .header("Content-Type", "application/json").when().
//  response = request.request(Method.GET,"/products");
//  response = request.request(Method.PUT,"/products/7");
// System.out.println("\n"+response.asPrettyString()); 
// System.out.println("\n"+response.getStatusLine()); 
 // int status_code = response.getStatusCode();
  
  //System.out.println("\n"+"\033[1m"+"Response status code:" +status_code+"\033[0m"+"\n");
  
  //response.then().log().all().assertThat().statusCode(status_code);
	}
}
