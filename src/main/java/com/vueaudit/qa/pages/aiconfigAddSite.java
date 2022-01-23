package com.vueaudit.qa.pages;

import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.vueaudit.qa.base.TestBase;
import com.vueaudit.qa.util.TestUtil;

import jdk.internal.org.jline.utils.Log;


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
   
   @FindBy(xpath="/html/body/ngx-app/ngx-pages/ngx-one-column-layout/nb-layout/div/div/div/div/div/nb-layout-column/ngx-site/ngx-addsite/div/div/div/form/div[7]/button[1]")
	WebElement cancel_butn;
   
   @FindBy(xpath="/html/body/ngx-app/ngx-pages/ngx-one-column-layout/nb-layout/div/div/div/div/div/nb-layout-column/ngx-site/ngx-sitelist/div/div/div/div[1]/span/button[1]")
   WebElement addnewsite;
   
   @FindBy(xpath="/html/body/ngx-app/ngx-pages/ngx-one-column-layout/nb-layout/div/div/div/div/div/nb-layout-column/ngx-site/ngx-sitelist/div/div/div/div[2]/div/nb-accordion/nb-accordion-item[1]/nb-accordion-item-header/span[2]/button[1]")
   WebElement camerabutton;	
   
   @FindBy(xpath="/html/body/ngx-app/ngx-pages/ngx-one-column-layout/nb-layout/div/div/div/div/div/nb-layout-column/ngx-site/ngx-cameralist/div/div/div/div/nb-tabset/nb-tab/div/div/nb-accordion/nb-accordion-item[1]/nb-accordion-item-header/span[2]/button[1]")
   WebElement schedulecamerabutton;
   
   @FindBy(xpath="/html/body/ngx-app/ngx-pages/ngx-one-column-layout/nb-layout/div[1]/div/div/div/div/nb-layout-column/ngx-site/ngx-sitelist/div/div/div/div[2]/div/nb-accordion/nb-accordion-item[6]/nb-accordion-item-header/span[2]/button[3]")
   WebElement deletecamera; 
   
   @FindBy(xpath="/html/body/ngx-app/ngx-pages/ngx-one-column-layout/nb-layout/div[1]/div/div/div/div/nb-layout-column/ngx-site/ngx-cameralist/div/div/div/div/nb-tabset/nb-tab/div/div/nb-accordion/nb-accordion-item[1]/nb-accordion-item-header/span[2]/button[2]")
   WebElement edit;
   
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
	
	public void cancel() {
		String url=commanmethods.geturl(prop.getProperty("url"))+":4201/aiconfig/site/add";
		commanmethods.launch_URL(url);
		commanmethods.explicitwait_Elementtobeclickable(address);
	    cancel_butn.click();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		String actualurl=driver.getCurrentUrl();
		String Expectedurl="http://3.109.160.64:4201/aiconfig/site/list";
		Assert.assertEquals(actualurl, Expectedurl,"Expected result:Check whether user will be able to cancel add site selection :False");
		System.out.println("Check whether user will be able to cancel add site selection:True");
	    Log.info("Check whether user will be able to cancel add site selection:True");
	}
	
	public void addsitebutton() {
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		 boolean btn=addnewsite.isDisplayed();
		 if(btn==false) {
			 Assert.fail("add site button not present");
		 }else {
			 
			 addnewsite.click();
			driver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS);
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
			String Expectedurl1="http://3.109.160.64:4201/aiconfig/site/list";
			String actual=driver.getCurrentUrl();
			Assert.assertEquals(actual, Expectedurl1,"Site was not added Sucessfully");
			System.out.println("Site was added Sucessfully");
					
			 }	 
	}
	       public void camera_view() {
		    commanmethods.launch_URL("http://3.109.160.64:4201/aiconfig/site/list");
		    driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		    boolean camerpresent=camerabutton.isDisplayed();
		    Assert.assertEquals(camerpresent, true,"View Cameras button not present or not working");
		    camerabutton.click();
		    driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS); 
		    String actual=driver.getCurrentUrl();
		    String Expected="http://3.109.160.64:4201/aiconfig/site/2/cameras";
		    Assert.assertEquals(actual, Expected);
		    boolean Expected1=true;
		    boolean actual1=schedulecamerabutton.isDisplayed();
		    Assert.assertEquals(actual1, Expected1,"Please add the cameras and run the test again");
		    System.out.println("Check whether user will be able to view list of cameras under particular site:True");
	       }
	 
	public void delete() {
		commanmethods.launch_URL("http://3.109.160.64:4201/aiconfig/site/list");
	    driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	    boolean b=deletecamera.isDisplayed();
	    Assert.assertEquals(b, true);
	    
	}
	public void edit_camera() {
		commanmethods.launch_URL("http://3.109.160.64:4201/aiconfig/site/list");
		commanmethods.explicitwait_Elementtobeclickable(camerabutton);
		boolean b=camerabutton.isDisplayed();
		String Expected="http://3.109.160.64:4201/aiconfig/site/3/cameras";
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(actual, Expected,"Please check the case again or view camera button was not clicked properly");
		boolean b1=deletecamera.isDisplayed();
		boolean b2=true;
		Assert.assertEquals(b1, b2,"No camera added");
		boolean b3=edit.isDisplayed();
		boolean b4=true;
		Assert.assertEquals(b3, b4,"Not able to find edit button");
		edit.click();
		String expectedurl="http://3.109.160.64:4201/aiconfig/camera/edit/3";
		String actualurl=driver.getCurrentUrl();
		Assert.assertEquals(actualurl, expectedurl,"Unable to reach updated page");
		
		
	}
}
