package patrick.hally.APITestingFramework.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import patrick.hally.APITestingFramework.APIs.CreateCustomerAPI;
import patrick.hally.APITestingFramework.setUp.BaseTest;
import patrick.hally.APITestingFramework.utilities.DataUtil;

//import static io.restassured.RestAssured.*;

import java.util.Hashtable;

public class CreateCustomerTest extends BaseTest {

	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
	public void validateCreateCustomerAPIWithValidSecretKey(Hashtable<String, String> data) {

		Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerAPIWithValidAuthKey(data);
		
		response.prettyPrint();
		
		System.out.println(response.statusCode());

		Assert.assertEquals(response.statusCode(), 200);

		System.out.println(data.get("name") + "---" + data.get("email") + "---" + data.get("description"));
	}

	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
	public void validateCreateCustomerAPIWithInValidSecretKey(Hashtable<String, String> data) {

		Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerAPIWithInValidAuthKey(data);

		response.prettyPrint();
		System.out.println(response.statusCode());

		Assert.assertEquals(response.statusCode(), 401);
		System.out.println(data.get("name") + "---" + data.get("email") + "---" + data.get("description"));

	}

}
