package com.vueaudit.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.vueaudit.qa.base.TestBase;
import com.vueaudit.qa.util.TestUtil;

public class aiconfigAddSite extends TestBase {
	 
	
	@FindBy(xpath="/html/body/ngx-app/ngx-pages/ngx-one-column-layout/nb-layout/div/div/div/div/div/nb-layout-column/ngx-site/ngx-addsite/div/div/div/form/div[1]/input")
	WebElement sitename_textbox;
	
   @FindBy(xpath="//textarea[@id='input-text-area']")
   WebElement description;
   
   @FindBy(xpath="/html/body/ngx-app/ngx-pages/ngx-one-column-layout/nb-layout/div/div/div/div/div/nb-layout-column/ngx-site/ngx-addsite/div/div/div/form/div[3]/ng-select/div/div/div[2]/input")
   WebElement tag;
   
   @FindBy(xpath="//input[@formcontrolname='address']")
   WebElement address;
   
   @FindBy(xpath="//button[@id='btn-edit-alarm-submit']")
   WebElement submitbutn;
   
   @FindBy(xpath="//span[@class='float-right mr-2 cursor']")
   WebElement hyper_site;
   
	
	TestUtil commanmethods=new TestUtil(driver);
	
	public aiconfigAddSite(){
		PageFactory.initElements(driver, this);
	}
	
	public void addsite() {
		String url=commanmethods.geturl(prop.getProperty("url"))+":4201/aiconfig/site/add";
		commanmethods.launch_URL(url);
		commanmethods.explicitwait_Visibilityofelement(sitename_textbox);
		sitename_textbox.click();
		sitename_textbox.sendKeys("jibin");
		//commanmethods.javascript_sendKeys(sitename_textbox);
		commanmethods.explicitwait_Visibilityofelement(description);
		description.sendKeys("For Automation testing");
		commanmethods.explicitwait_Visibilityofelement(tag);
		tag.sendKeys("Front Area");
		tag.sendKeys(Keys.ENTER);
		commanmethods.explicitwait_Visibilityofelement(address);
		address.sendKeys("nothing");
		commanmethods.scroll_at_the_bottom_of_the_page();
		commanmethods.explicitwait_Elementtobeclickable(submitbutn);
		submitbutn.click();
		String Expectedurl="http://3.109.160.64:4201/aiconfig/site/list";
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(actual, Expectedurl,"Site was not added Sucessfully");
		System.out.println("Site was added Sucessfully");
	}
	
	public void to_sitelist() {
		String url=commanmethods.geturl(prop.getProperty("url"))+":4201/aiconfig/site/add";
		commanmethods.launch_URL(url);
		commanmethods.explicitwait_Elementtobeclickable(hyper_site);
		hyper_site.click();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		String actualurl=driver.getCurrentUrl();
		String Expectedurl="http://3.109.160.64:4201/aiconfig/site/list";
		
		Assert.assertEquals(actualurl, Expectedurl,"Not able to click on the sitelink-hyperlink");
		
	}
	
}
