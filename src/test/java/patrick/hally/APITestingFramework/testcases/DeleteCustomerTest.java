package patrick.hally.APITestingFramework.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import patrick.hally.APITestingFramework.APIs.DeleteCustomerAPI;
import patrick.hally.APITestingFramework.setUp.BaseTest;
import patrick.hally.APITestingFramework.utilities.DataUtil;
import patrick.hally.APITestingFramework.utilities.TestUtil;

public class DeleteCustomerTest extends BaseTest {
	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
	public void deleteCustomer(Hashtable<String, String> data) {

		Response response = DeleteCustomerAPI.sendDeleteRequestToDeleteCustomerAPIWithValidID(data);
		response.prettyPrint();
		
		
		System.out.println(response.statusCode());

		/*
		 * String actual_id = response.jsonPath().get("id").toString();
		 * 
		 * System.out.println("Getting id from Json path: "+ actual_id);
		 * 
		 * Assert.assertEquals(actual_id, data.get("id"), "ID not matching");
		 */

		/*
		 * JSONObject jsonObject = new JSONObject(response.asString());
		 * System.out.println(jsonObject.has("id"));
		 * Assert.assertTrue(jsonObject.has("id")
		 * ,"ID key is not present in the JSON response");
		 */

		System.out.println("Presence check for Deleted Key : " + TestUtil.jsonHasKey(response.asString(), "deleted"));
		System.out.println("Presence check for Object Key : " + TestUtil.jsonHasKey(response.asString(), "object"));
		Assert.assertTrue(TestUtil.jsonHasKey(response.asString(), "id"), "ID key is not present in the JSON response");

		String actual_id = TestUtil.getJsonKeyValue(response.asString(), "id");
		System.out.println(actual_id);
		Assert.assertEquals(actual_id, data.get("id"), "ID not matching");

		System.out.println("Object key value is : " + TestUtil.getJsonKeyValue(response.asString(), "object"));
		System.out.println("Deleted key value is : " + TestUtil.getJsonKeyValue(response.asString(), "deleted"));

		Assert.assertEquals(response.statusCode(), 200);

	}

}
