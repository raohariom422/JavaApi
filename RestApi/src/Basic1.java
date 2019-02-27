import io.restassured.RestAssured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Basic1 {
	static Properties prop=new Properties();
	@BeforeTest
	
	public void getdata() throws IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Hariom\\Automation\\RestApi\\RestApi\\src\\files\\env.properties");
		prop.load(fis);
	}
@Test
	public static void Test1(){
		// TODO Auto-generated method stub
		RestAssured.baseURI=prop.getProperty("HOSTGET");
		
		//Given all- parameters
		
		 given().
		
		        param("location","10.9581372,79.3272918").
		        param("radius","5000").
		        param("type","schools").
		        param("key",prop.getProperty("KEYGET")).
		        when().
		        get("/maps/api/place/nearbysearch/json").
		        then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		        body("results[0].name",equalTo("Kumbakonam")).and().
		        body("results[0].place_id", equalTo("ChIJGTQ1YLMyVToRNa0TRNm17Ak")).and().
		        header("Server", "scaffolding on HTTPServer2");
		
		        
		        
		        
		

	}

}
