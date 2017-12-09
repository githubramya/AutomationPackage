package Generic;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConstant {
	
	public static WebDriver driver;
	
	static {
		
		System.setProperty(GECHO_KEY, GECHO_PATH);
		System.setProperty(CHROME_KEY, CHROME_PATH);
	}
	@BeforeMethod
	public void openApplication() {
		driver=new FirefoxDriver();
		String URL = Lib.getProperty(CONFIG_PATH,"URL");
		driver.get(URL);
		String ITO = Lib.getProperty(CONFIG_PATH, "ImplicitTimeOut");
		int timeoutPeriod = Integer.parseInt(ITO);
		driver.manage().timeouts().implicitlyWait(timeoutPeriod, TimeUnit.SECONDS);
				
	}
	
		@AfterMethod
	public void closeApplication() {
		driver.close();
		
	}
	
    public void takeScreenshots(String TestName) {
    	Date d= new Date();
    	String currentdate = d.toString().replaceAll(":","_");
		
		TakesScreenshot ts= (TakesScreenshot)driver;
		File scrFile= ts.getScreenshotAs(OutputType.FILE);
		File destFile= new File(".\\Screenshots\\"+currentdate+"\\"+TestName+"_screenshot.png");
		try {
			FileUtils.copyFile(scrFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
