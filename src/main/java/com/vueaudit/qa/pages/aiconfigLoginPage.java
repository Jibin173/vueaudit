package com.vueaudit.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vueaudit.qa.base.TestBase;
import com.vueaudit.qa.util.TestUtil;

public class aiconfigLoginPage extends TestBase{
    @FindBy(xpath="//input[@id='inputEmail']")
    WebElement Username_textbox;
	
    @FindBy(xpath="//input[@id='inputPassword']")
    WebElement Password_textbox;
    
    @FindBy(xpath="//button[@id='submitButton']")
    WebElement Submit;
    
    @FindBy(xpath="//div[@class='user-container']")
    WebElement verify_homepage; 
    
    @FindBy(xpath="//p[@role='alert']")
    WebElement alert_OnWrongUnameorPass;
    
	TestUtil commanmethods=new TestUtil(driver);
	
	public aiconfigLoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean Login() {
		try {
			String username  =prop.getProperty("username");
			String passwords =prop.getProperty("password");
		    commanmethods.launch_URL(prop.getProperty("url"));
		    commanmethods.explicitwait_Visibilityofelement(Username_textbox);
		    Username_textbox.sendKeys(username);
		    commanmethods.explicitwait_Visibilityofelement(Password_textbox);
		    Password_textbox.sendKeys(passwords);
		    commanmethods.explicitwait_Elementtobeclickable(Submit);  
		    Submit.click();
		    commanmethods.explicitwait_Visibilityofelement(verify_homepage);
		    return true;
		}catch(Exception e) {
			return false;
		}
		
	}
	
	
	public boolean IncorrectLogin() {
		try {
			String username1  =prop.getProperty("username1");
			String passwords1 =prop.getProperty("password1");
		    commanmethods.launch_URL(prop.getProperty("url"));
		    commanmethods.explicitwait_Visibilityofelement(Username_textbox);
		    Username_textbox.sendKeys(username1);
		    commanmethods.explicitwait_Visibilityofelement(Password_textbox);
		    Password_textbox.sendKeys(passwords1);
		    commanmethods.explicitwait_Elementtobeclickable(Submit);  
		    Submit.click();
		    commanmethods.explicitwait_Visibilityofelement(alert_OnWrongUnameorPass);
		    return true;
		}catch(Exception e) {
			return false;
		}
		
	}
	
	
}
