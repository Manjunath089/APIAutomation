package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
//import com.sun.xml.fastinfoset.sax.Properties;
import java.util.Properties;

import com.sun.xml.xsom.impl.scd.ParseException;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import stepDefinations.StepDefination;

public class Utils {

	public static RequestSpecification res;
	public static int i=0;
	public static String getCurrentDateTimeMS() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddHHmmss");
		String datetime = ft.format(dNow);
		return datetime;
	}
	
	public  Date getdate(String expiresAt) throws ParseException, java.text.ParseException
    {	
        String dNow = expiresAt;
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Date datetime = ft.parse(dNow);
        return datetime;
        
        
       
       
    }

	public RequestSpecification givenHeader() throws IOException {
		if (res == null) {
			PrintStream log = new PrintStream(new FileOutputStream("logging.txt", true));
			res = new RequestSpecBuilder().setBaseUri(getGlobalValues("baseUrl"))
					 .addHeader("Cookie", "BC_JSESSIONID="+StepDefination.getCookie)
					.addHeader("X-XSRF-TOKEN", StepDefination.token)
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log))
					.setContentType(ContentType.JSON).build();
			return res;
		}
		return res;
	}
	
	public RequestSpecification givenHeaderget() throws IOException {
		if (res == null) {
			PrintStream log = new PrintStream(new FileOutputStream("logging.txt", true));
			res = new RequestSpecBuilder().setBaseUri(getGlobalValues("baseUrl"))
					 .addHeader("Cookie", "BC_JSESSIONID="+StepDefination.getCookie)
					.addHeader("X-XSRF-TOKEN", StepDefination.token)
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log))
					.setContentType(ContentType.JSON).build();
			return res;
		}
		return res;
	}
	public static String getGlobalValues(String key) throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//java//resources//global.properties");
		prop.load(fis);
		return prop.getProperty(key);

	}

	public static ResponseSpecification successResponse() {
		return new ResponseSpecBuilder().expectStatusCode(201).build();
	}

	public static ResponseSpecification invalidResponse() {
		return new ResponseSpecBuilder().expectStatusCode(400).build();
	}
	public static ResponseSpecification successResponseget() {
		return new ResponseSpecBuilder().expectStatusCode(200).build();
	}
	
}