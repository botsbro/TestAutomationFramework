package pageEvents;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import static io.restassured.RestAssured.*;


public class ZippopotamusEvents {

    RequestSpecification apiRequest;
    Response apiResponse;
    ResponseBody apiResponseBody;
    String apiResponseBodyAsString;
    JsonPath jsonPathFromApiResponse;

    public void setApiURL(String url){
        RestAssured.baseURI = url;
    }

    public void sendApiRequest(){
        apiResponse = get(RestAssured.baseURI);
        //apiResponse = get(RestAssured.baseURI).then().extract().response();
        apiResponseBody = apiResponse.getBody();
        apiResponseBodyAsString = apiResponseBody.asString();
        jsonPathFromApiResponse = apiResponse.jsonPath();
    }

    public void checkForCorrectPlaceName(String expectedPlaceName){
        String returnedPlace = jsonPathFromApiResponse.get("['place name']");
        //Assert.assertEquals(apiResponseBodyAsString.contains(expectedPlaceName), true);
        Assert.assertEquals(returnedPlace, expectedPlaceName);
    }

    public void checkForCorrectPostcode(String expectedPostcode){
        String returnedPostcode = jsonPathFromApiResponse.get("post code");
        //Assert.assertEquals(apiResponseBodyAsString.contains(expectedPostCode), true);
        Assert.assertEquals(returnedPostcode, expectedPostcode);
    }

    public void checkForCorrectStatusCode(String expectedStatusCode){
        int expectedStatusCodeInt = Integer.parseInt(expectedStatusCode); //parseInt because the feature file reads the number as a string
        int returnedStatusCode = apiResponse.statusCode();
        Assert.assertEquals(returnedStatusCode, expectedStatusCodeInt);
    }




}
