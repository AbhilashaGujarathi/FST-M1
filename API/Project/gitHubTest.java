package liveProject;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class gitHubTest {
    private static String sshKey;
    private static int sshKeyId;
    private static RequestSpecification requestSpec;
    static ResponseSpecification responseSpec;

    @BeforeClass
    public static void setUp() {
        // Set up RequestSpecification
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.github.com")
                .setContentType("application/json")
                .addHeader("Authorization", "token <token added here>")
                .build();

        // Initialize SSH key and ID
        sshKey = "ssh-ed25519";
        sshKeyId = 0; // Initialize to 0, will be updated after POST request

        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(201)
                .expectResponseTime(lessThanOrEqualTo(15000L))
                .build();
    }

    @Test(priority = 1)
    public void testAddSSHKey() {
        // Create request body
        String requestBody = "{\"title\": \"TestAPIKey\", \"key\": \"" + sshKey + "\"}";

        // Send POST request
        Response response = RestAssured.given()
                .spec(requestSpec)
                .body(requestBody)
                .when()
                .post("/user/keys");

        // Assert status code is 201
        response.then().statusCode(201);

        // Extract SSH key ID from response and update variable
        sshKeyId = response.then().extract().path("id");
        
    }

    @Test(priority = 2)
    public void testGetSSHKey() {
        // Send GET request to get added SSH key
        Response response = RestAssured.given()
                .spec(requestSpec)
                .pathParam("keyId", sshKeyId)
                .when()
                .get("/user/keys/{keyId}");

        // Assert status code is 200
        response.then().statusCode(200);

        // Print response
        System.out.println("Response for Get SSH Key:");
        System.out.println(response.asString());
    }

    @Test(priority = 3)
    public void testDeleteSSHKey() {
        // Send DELETE request to delete added SSH key
        Response response = RestAssured.given()
                .spec(requestSpec)
                .pathParam("keyId", sshKeyId)
                .when()
                .delete("/user/keys/{keyId}");

        // Assert status code is 204
        response.then().statusCode(204);

        // Print response
        System.out.println("Response for Delete SSH Key:");
        System.out.println(response.asString());
    }
}
