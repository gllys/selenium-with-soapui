package soapui.login;
import data_source.BrowersType;
import data_source.browers_set;

import DO_source.DO;
//import wait_source.Wait;

public class LogIn {
	public static final String URL = "http://www.piaotai.com";
	
	private DO du;
     

	public  String LogInTest()
	
	{
		browers_set browser = new browers_set(BrowersType.chrome);
	    
		du = new DO(browser.web_driver);   
		du.getDriver().get(URL);
		du.what("username").clear();
		du.what("username").sendKeys("gllysleletian");
		du.what("password").sendKeys("0823letian");
		du.what("submit").submit();
		
		
		return du.what("title").getText();
		

	}


//	public static void main(String arg[]) {
//       
//		System.out.println(new LogIn().LogInTest("gllysleletian","0823letian"));
//		
//	}
//
}