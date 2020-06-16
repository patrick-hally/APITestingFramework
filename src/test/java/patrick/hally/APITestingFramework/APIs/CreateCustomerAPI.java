package patrick.hally.APITestingFramework.APIs;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import io.restassured.response.Response;
import patrick.hally.APITestingFramework.setUp.BaseTest;

public class CreateCustomerAPI extends BaseTest {

	public static Response sendPostRequestToCreateCustomerAPIWithValidAuthKey(Hashtable<String, String> data) {

		// Authorization needed by Stripe to interact with API
		Response response = given().auth().basic(config.getProperty("validSecretKey"), "")
				.formParam("email", data.get("email")).formParam("description", data.get("description"))
				.post(config.getProperty("customerAPIEndPoint"));

		return response;
	}

	public static Response sendPostRequestToCreateCustomerAPIWithInValidAuthKey(Hashtable<String, String> data) {
		// Authorization needed by Stripe to interact with API
		Response response = given().auth().basic(config.getProperty("inValidSecretKey"), "")
				.formParam("email", data.get("email")).formParam("description", data.get("description"))
				.post(config.getProperty("customerAPIEndPoint"));

		return response;
	}
}
