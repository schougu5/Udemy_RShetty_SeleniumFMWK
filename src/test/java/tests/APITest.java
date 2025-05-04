package tests;
//pull request from git to intelliJ-demo
//Use it for creating a new branch-QA

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import testComponents.BaseTest;

public class APITest extends BaseTest {

	@Test
    public void getUserDetails() {
        // Set the base URI for the API
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        
        
        Response response =  RestAssured.given().when().get("/users/1");
        // Make the GET request
      
        
        // Validate the status code (200 OK)
        Assert.assertEquals(response.statusCode(), 200);
        
        // Print the response body
        System.out.println("Response Body: " + response.getBody().asString());
        
        // Extracting a field from the JSON response
        String name = response.jsonPath().getString("name");
        System.out.println("User Name: " + name);
        
        // Assert if the extracted name matches expected value
        Assert.assertEquals(name, "Leanne Graham");
    }
	
}
