package testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vueaudit.qa.base.TestBase;
import com.vueaudit.qa.pages.aiconfigAddSite;
import com.vueaudit.qa.pages.aiconfigLoginPage;
import com.vueaudit.qa.util.TestUtil;

public class aiconfigsitepagetest extends TestBase {
	aiconfigLoginPage loginpage;
	TestUtil commanmethods;
	Logger Log ;
	aiconfigAddSite sitepage;
	
	public aiconfigsitepagetest(){
		super();
	}
	
	@BeforeMethod
	public void setup() {
		try {
			initialization();
			Log= Logger.getLogger(aiconfigsitepagetest.class);
			loginpage=new aiconfigLoginPage();
			commanmethods=new TestUtil(driver);
	        sitepage=new aiconfigAddSite();		
			Log.info("Pre Condtion Installed");
			System.out.println("Pre Condtion Installed");
		}catch(Exception e) {
			Log.info("Something went wrong while Setup methods was executing.Please check and re run the TestCase");
		    System.out.println("Something went wrong while Setup methods was executing.Please check and re run the TestCase");
		}
	}
	
	@Test(enabled=true)
	public void TC3() {
    Log.info("To Check whether user will be able to add site");
    System.out.println("To Check whether user will be able to add site");
    loginpage.Login();
    sitepage.addsite();
	 	
	}
	
	@Test(enabled=true)
	public void TC4() {
		Log.info("Check if it is possible for a user to navigate to the  site list section from add site section");
	    System.out.println("Check if it is possible for a user to navigate to the  site list section from add site section");
	    loginpage.Login();
	    sitepage.to_sitelist();
	}
	
	@AfterMethod
	public void teardownmethod() {
		driver.close();
	}
	
}
