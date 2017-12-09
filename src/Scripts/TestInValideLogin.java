package Scripts;

import org.testng.annotations.Test;

import Generic.BaseTest;
import Generic.Lib;
import pompages.LoginPage;

public class TestInValideLogin extends BaseTest {
	@Test
	public void testInValideLogin() {
		
    LoginPage l=new LoginPage(driver);
    int rowcount = Lib.getRowCount(EXCEL_PATH, "InvalidLogin");
    System.out.println(rowcount);
    for(int i=1;i<=rowcount;i++) {
	String un = Lib.getCellValue(EXCEL_PATH, "InvalidLogin", i, 0);
	String pw = Lib.getCellValue(EXCEL_PATH, "InvalidLogin", i, 1);
       
    
    l.setUsername(un);
    l.setPassword(pw);
    l.clickLogin();
    }
	}
}
