package soapui.login;

import datasource.*;
import dosource.*;



//import wait_source.Wait;

public class login {
	public static final String URL = "http://www.piaotai.com";
	
	private Do du;
     

	public  String LogInTest()
	
	{
		browsersset browser = new browsersset(browserstype.chrome);
	    
		du = new Do(browser.web_driver);   
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