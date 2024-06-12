package liveProject;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {


    // set headers

    Map<String, String> headers = new HashMap<>();

    @Pact(consumer = "UserConsumer", provider = "UserProvider")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        // set header

        headers.put("Content-Type", "application/json");

        // Create a JSON body
        DslPart reqResBody = new PactDslJsonBody()
                .numberType("id", 3242)
                .stringType("firstName", "fasfas")
                .stringType("lastName", "dsfsdfsfd")
                .stringType("email", "ffdsfsfew@ewf.com");

        //create the contract pact
        return builder.given("Post Request")
                .uponReceiving("A request to create a user")
                .method("POST")
                .path("/api/users")
                .headers(headers)
                .body(reqResBody)
                .willRespondWith()
                .status(201)
                .body(reqResBody)
                .toPact();

    }


    //create contract


    //COnsumer test with mock provider
    @Test
    @PactTestFor(providerName = "UserProvider", port = "8282")
    public void postRequestTest() {
        Map<String, Object> reqbody = new HashMap<>();
        reqbody.put("id", 3242);
        reqbody.put("firstName", "fasfas");
        reqbody.put("lastName", "dsfsdfsfd");
        reqbody.put("email", "ffdsfsfew@ewf.com");

        given().baseUri("http://localhost:8282/api/users").headers(headers).body(reqbody).log().all();
        when().post().
                then().statusCode(201).body("email", equalTo("ffdsfsfew@ewf.com")).log().all();
    }
}
