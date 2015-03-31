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

package datasource;

import java.io.File;
import java.io.IOException;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import datasource.browserstype; //ö�ٳ�ʼ��

public class browsersset {

	public WebDriver web_driver = null; // driver��ʼ��
	private FirefoxProfile firefoxprofile = null;   //firefox��ʼ����firefox�������÷�ʽ��ʹ��profile����
	private static DesiredCapabilities caps = null; // ��������ó�ʼ����IE��CHROME
	private String projectpath = System.getProperty("user.dir"); // ��Ŀ·�����ã��ӽ�ʹ��

	public browsersset(browserstype browserstype) {
		switch (browserstype) // ö�ٷ����ж�ѭ��
		{
		case firefox:
			File firebug = new File(projectpath + "/tools/firebug-2.0.7.xpi");     // firefox���з��������������ļ��������
			File firepath = new File(projectpath+ "/tools/FireXPath-0.9.7.1.xpi"); 
			firefoxprofile = new FirefoxProfile();                                 // �����õ�profile������profile��ʼ��
			try {
				firefoxprofile.addExtension(firebug);                              //����������Ч
				firefoxprofile.addExtension(firepath);                             //����������Ч
				firefoxprofile.setPreference("webdriver.accept.untrusted.certs", "true"); //���������
				firefoxprofile.setPreference("extensions.firebug.currentVersion", "2.0.7");//ȷ��firebug��ǰ�汾��ֹ��ʾ��ͻ
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			web_driver = new FirefoxDriver(firefoxprofile);//��profile������driver�����
			web_driver.manage().window().maximize();//���þ������󻯴��ڷ���
			break;//���������߼�
		case ie:
			System.setProperty("webdriver.ie.driver", projectpath+ "/tools/IEDriverServer64.exe");
			caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS,false);
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
			caps.setCapability("ignoreZoomSetting", true);
			web_driver = new InternetExplorerDriver(caps);
			web_driver.get("javascript:document.getElementById('overridelink').click();");
			web_driver.manage().window().maximize();
			break;
		case chrome:
			System.setProperty("webdriver.chrome.driver","C:/Users/Administrator/git/selenium-with-soapui/tools/chromedriver.exe");
			caps = DesiredCapabilities.chrome();
			caps.setCapability("chrome.switches",Arrays.asList("--start-maximized")); // ���browser
			// capabilities.setCapability("chrome.switches",
			// Arrays.asList("--proxy-server=http://your-proxy-domain:4443"));
			//���ô���
			web_driver = new ChromeDriver(caps);
			web_driver.manage().window().maximize();
			break;

		}

	}

}
