package SoapUi.LogIn;

import org.openqa.selenium.WebDriver;


import data_source.BrowersType;
import data_source.browers_set;

import DO_source.DO;
//import wait_source.Wait;

public class LogIn {
	private WebDriver driver;
	private DO du;

	private String Url = "http://www.piaotai.com";
	public  String LogInTest() {
		browers_set browser = new browers_set(BrowersType.chrome);
		driver = browser.web_driver;
		du = new DO(driver);   
		driver.get(Url);
		du.what("username").clear();
		du.what("username").sendKeys("gllysleletian");
		du.what("password").sendKeys("0823letian");
		du.what("submit").submit();
		return du.what("title").getText();
		

	}


	public static void main(String arg[]) {
       
		System.out.println(new LogIn().LogInTest());
		
	}

}