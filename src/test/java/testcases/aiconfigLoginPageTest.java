package testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vueaudit.qa.base.TestBase;
import com.vueaudit.qa.pages.aiconfigLoginPage;
import com.vueaudit.qa.util.TestUtil;

import jdk.internal.org.jline.utils.Log;

import org.apache.log4j.Logger;
public class aiconfigLoginPageTest extends TestBase {

	aiconfigLoginPage loginpage;
	TestUtil commanmethods;
	Logger Log ;
	
	public aiconfigLoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup() {
		try {
			initialization();
			Log= Logger.getLogger(aiconfigLoginPageTest.class);
			loginpage=new aiconfigLoginPage();
			commanmethods=new TestUtil(driver);
			Log.info("Pre Condtion Installed");
			System.out.println("Pre Condtion Installed");
		}catch(Exception e) {
			Log.info("Something went wrong while Setup methods was executing.Please check and re run the TestCase");
		    System.out.println("Something went wrong while Setup methods was executing.Please check and re run the TestCase");
		}
	}
	
	@Test(priority=1, enabled=true )
	public void TC1() throws IOException {
		Log.info("To Validate Sign-in button using valid username and password");
		System.out.println("To Validate Sign-in button using valid username and password");
		boolean actual=loginpage.Login();
		if(actual==false) {
			Log.info("To Validate Sign-in button using valid username and password:False");
			System.out.println("To Validate Sign-in button using valid username and password:False");
	        commanmethods.takeScreenshotAtEndOfTest(); 
		}else {
			Log.info("To Validate Sign-in button using valid username and password:true");
		    System.out.println("To Validate Sign-in button using valid username and password:true");
		}
		Assert.assertEquals(actual, true);
	}
	
	
	@Test(priority=2, enabled=true)
	public void TC2() throws IOException {
		Log.info("To Validate Sign-in button using invalid username and invalid password");
		System.out.println("To Validate Sign-in button using invalid username and invalid password");
        boolean actual=loginpage.IncorrectLogin();
        if(actual==false) {
        	Log.info("To Validate Sign-in button using invalid username and invalid password:False");
			System.out.println("To Validate Sign-in button using invalid username and invalid password:False");
	        commanmethods.takeScreenshotAtEndOfTest(); 	
        }else{
        	Log.info("To Validate Sign-in button using invalid username and invalid password:true");
		    System.out.println("To Validate Sign-in button using invalid username and invalid password:true");
        }
		
		
	}
	
	
	

}
