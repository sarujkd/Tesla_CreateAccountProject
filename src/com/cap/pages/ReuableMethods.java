package com.cap.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.LogStatus;

import testBase.BaseTest;

public class ReuableMethods extends BaseTest{

	
	/*
	 * name of the method: switchFrameid BriefDescription : iframe using webelement
	 * Arguments : driver--->driver obj--->iframe id  
	 */

	public static void SwitchFrame(String id) {
		driver.switchTo().frame(id);
		System.out.println("Pass: we can switch to the " + id + " frame");
	}
	
	public static void SwitchFrame(WebElement element) {
		driver.switchTo().frame(element);
		System.out.println("Pass: we can switch to the frame");
	}

	public static void SwitchFrame() {
		driver.switchTo().defaultContent();
		System.out.println("Pass: we can switch to the frame");
	}

	
	/* name of the method:   mouseOver
	 * BriefDescription  :   mouseOver  
	 * Arguments         :  obj,index 
	*/
	public static void MouseOver(WebDriver driver,WebElement obj) {
		if(obj.isDisplayed()) {
	   Actions action=new Actions(driver);
	   action.moveToElement(obj).build().perform();
		System.out.println("Pass: "+obj+" is present");
		logger.log(LogStatus.PASS,  "obj is present" );
		}
	 else {
			System.out.println("Fail:"+obj+" is not present.Please chk application");
			logger.log(LogStatus.FAIL,  "obj is not present.Please chk application" );
		}
	}


	/*
	 * name of the method: EnterText BriefDescription : entering textvalue for
	 * textbox Arguments : element --->object text --->to be entered objName
	 * --->object name
	 */
	public static void EnterText(WebElement element, String text, String objName) {
		if (element == null || !element.isDisplayed()) {
			logger.log(LogStatus.ERROR, objName + " Textbox is not found.");
		} else {
			logger.log(LogStatus.INFO, objName + " Textbox is found");
			element.sendKeys(text);
		}
	}

	//Click the element
	public static void Click(WebElement element, String objName) {
		if (element == null || !element.isDisplayed()) {
			logger.log(LogStatus.ERROR, objName + " Element is not found.");
		} else {
			logger.log(LogStatus.INFO, objName + " Element is found");
			element.click();
		}
	}
}
	
	
