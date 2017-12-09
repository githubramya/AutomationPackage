package Scripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Generic.BaseTest;
import Generic.Lib;
import pompages.LoginPage;

public class TestLogin  extends BaseTest{
	
	
	@Test
	public void testLogin() throws InterruptedException {
		
		LoginPage lg=new LoginPage(driver);
		String un = Lib.getCellValue(EXCEL_PATH, "ValidLogin", 1, 0);
		String pw = Lib.getCellValue(EXCEL_PATH, "ValidLogin", 1, 1);
		String ExpectedTitle=Lib.getCellValue(EXCEL_PATH, "ValidLogin", 1, 2);
		
		
		lg.setUsername(un);
		lg.setPassword(pw);
		lg.clickLogin();
		Thread.sleep(6000);
		
		String actualTitle= driver.getTitle();
		SoftAssert s=new SoftAssert();
		s.assertEquals(actualTitle, ExpectedTitle);
		s.assertAll();
		
	}
	
	

}
