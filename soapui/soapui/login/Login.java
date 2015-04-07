
	/**
	 * 
	 * Description :switch to specific window.
	 * @author :Gllys Zhang
	 * @see : 
	 * @param :partial Title Name of a window.
	 * @return : void
	 * @create :2015-03-10
	 * @exception :
	 * @version :1.0
	 */


package soapui.login;

import waitsource.wait;



import datasource.*;
import dosource.*;



//import wait_source.Wait;

public class Login {
	public static final String URL = "http://www.piaotai.com";
	
	private Do du;

	

	public  String LogInTest()
	
	{
		BrowsersSet browser = new BrowsersSet(BrowsersType.chrome);
		
		du = new Do(browser.web_driver);   
		du.getDriver().get(URL);
		du.what("username").clear();
		du.what("username").sendKeys("gllysleletian");
		du.what("password").sendKeys("0823letian");
		du.what("submit").submit();
		du.waitForElementPresent("title");
		String title =du.what("title").getText();
		du.waitFor(5000);
		du.getDriver().close();
		du.getDriver().quit();
		return title;
		
	
	}

 
	
	

	

//	public static void main(String arg[]) {
//       
//		System.out.println(new login().LogInTest("gllysleletian","0823letian"));
//		
//	}

}