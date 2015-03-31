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


package waitsource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class wait {
	private WebDriver driver;//����driver
    private int timeout =30; //���峬ʱʱ��Ϊ10S
	
	public wait(WebDriver driver){
		this.driver = driver;//����Ҫʹ��This,this��ָ������driverΪǰ�����webdriver�����Ǻ����driver
        //PageFactory .initElements(driver, this);	-----> ���ҳ��Ԫ�ع��ڵ�����	
	}
	
	public void waitForElementPresent(String locator){
		try{
			(new WebDriverWait(driver, timeout)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		}catch(Exception e){
			
		}
		
	}

	
	public void waitForElementIsEnable(String locator){
		(new WebDriverWait(driver, timeout)).until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
	}
	
	public void waitFor(long timeout){
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
