package stepDefinations;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.sun.xml.xsom.impl.scd.ParseException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;
import pojo.InstallmentError;
import pojo.InstallmentScheduleSpecOutput;

import static io.restassured.RestAssured.given;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;


public class StepDefination extends Utils {
	RequestSpecification req;
	//ResponseSpecification resspec;
	Response output;
	ResponseBody<Response> response;
	String id;
	
	
	public static String token;
	public static String getCookie;
	TestDataBuild data = new TestDataBuild();
	@Given("generating Token")
	public String generating_token() {
	    
		Response response = given()
			    .header("Content-Type","application/x-www-form-urlencoded")
			    .formParam("j_username", "bc_admin").formParam("j_password", "Bcadmin@123")
			    .post("http://10.160.160.3:8001/bc/j_security_check").then().extract().response();
			  getCookie = response.getCookie("BC_JSESSIONID");


			  token = given().header("Cookie","BC_JSESSIONID="+getCookie).when()
			        .post("http://10.160.160.3:8001/bc/webresources/v1.0/private/utility/csrf/token")
			        .then().extract().response().asString();
			   System.out.println(token);
			   return token;
	}		   
			   
	
	@Given("Get header details")
	public void get_header_details() throws IOException {
	    
		req= given().log().all().spec(givenHeaderget());
	}
	
	@Given("Creating an InstallmentSchedule Spec {string} {string} {string} {int} {int} {string} {string} {string} {string} {string} {string} {string}")
	public void creating_an_installment_schedule_spec(String name, String minAmount, String minPercent, Integer maxIntervalDaysNEI, Integer maxNumNEI, String expiresAt, String installmentPeriod, String installmentType, String key, String value, String dataType, String operator ) throws IOException, ParseException, java.text.ParseException {
		req = given().spec(givenHeader()).body(data.InstallmentScheduleSpecificaton(name,minAmount, minPercent, maxIntervalDaysNEI, maxNumNEI, expiresAt, installmentPeriod, installmentType, key, value, dataType, operator ));
	 i=i+1;
	}
	
	
	@When("{string} API is called to create")
	public void api_is_called_to_create(String resource) {
		
		APIResources resourceAPI = APIResources.valueOf(resource);
		output = req.when().post(resourceAPI.getResource()).then().log().all().spec(successResponse()).extract().response();
	}
	
	@When("{string} API is called with invalid inputs")
	public void api_is_called_with_invalid_inputs(String resource) {
		APIResources resourceAPI = APIResources.valueOf(resource);
		output = req.when().post(resourceAPI.getResource()).then().spec(invalidResponse()).extract().response();
		
	}

	
	@When("{string} API is called with Get method")
	public void api_is_called_with_get_method(String resource) throws UnsupportedEncodingException {
		APIResources resourceAPI = APIResources.valueOf(resource);
		id = "0.0.0.1+-config-installment-schedule_spec+735425";
		output = req.when().get(resourceAPI.getResource()+id).then().log().all().spec(successResponseget()).extract().response();
	}
	
	
	@Then("Validate the {int} code and status in InstallmentScheduleSpec output response")
	public void validate_the_code_status_and_message_in_output_response(int ExpectedValue) {
		assertEquals(output.getStatusCode(),ExpectedValue);
	}
	

   @Then("Validate the {int} code , {string} , status, message and error message in output response")
     public void validate_the_code_status_message_and_error_message_in_output_response(int code, String message) {
	InstallmentError responseBody = output.getBody().as(InstallmentError.class);
	assertEquals(responseBody.getErrorCode(), code);
    assertEquals(responseBody.getErrorMessage(), message);
   }
   
   @Given("Creating an InstallmentSchedule Spec e2e {string} {string} {string} {int} {int} {string} {string} {string} {string} {string} {string} {string}")
   public void creating_an_installment_schedule_spec_e2e(String name, String minAmount, String minPercent, Integer maxIntervalDaysNEI, Integer maxNumNEI, String expiresAt, String installmentPeriod, String installmentType, String key, String value, String dataType, String operator ) throws IOException, ParseException, java.text.ParseException {
	   req = given().spec(givenHeader()).body(data.InstallmentScheduleSpecificaton(name,minAmount, minPercent, maxIntervalDaysNEI, maxNumNEI, expiresAt, installmentPeriod, installmentType, key, value, dataType, operator ));
   }
   
   @Then("{string} API is called with Get method with id")
   public void api_is_called_with_get_method_with_id(String resource) {
	   InstallmentScheduleSpecOutput responseBody = output.getBody().as(InstallmentScheduleSpecOutput.class);
	     id = responseBody.getId(); 
	   APIResources resourceAPI = APIResources.valueOf(resource);
	   output = req.when().get(resourceAPI.getResource()+id).then().log().all().spec(successResponseget()).extract().response();
   }

   @Given("Creating an Installment {string} {string} {string}{string} {int} {double} {string} {string} {string} {string} {string} {string} {string} {double} {string}")
	public void creating_an_installment(String billPreference, String status, String startDateTime, String endDateTime, Integer totalInstallments, Double amount, String currency, String customerRef, String billProfileRef, String billId, String scheduleSpecRef, String istatus, String idueDate, Double iamount, String icurrency) throws IOException, ParseException, java.text.ParseException {
		req = given().spec(givenHeader()).body(data.InstallmentSchedule(billPreference, status, startDateTime, endDateTime, totalInstallments, amount, currency, customerRef, billProfileRef, billId, scheduleSpecRef, istatus, idueDate, iamount, icurrency));
		                                                                                                                                                                   
	}
	
	
}
