package patrick.hally.APITestingFramework.APIs;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import io.restassured.response.Response;
import patrick.hally.APITestingFramework.setUp.BaseTest;

public class DeleteCustomerAPI extends BaseTest {

	public static Response sendDeleteRequestToDeleteCustomerAPIWithValidID(Hashtable<String, String> data) {

		// Authorization needed by Stripe to interact with API
		Response response = given().auth().basic(config.getProperty("validSecretKey"), "")
				.delete(config.getProperty("customerAPIEndPoint") + "/" + data.get("id"));

		return response;

	}
}
