package com.cap.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseTest;

public class GooglePage extends ReuableMethods {

	@FindBy(name="q")
	WebElement searchBox;
	
	public GooglePage() {

		PageFactory.initElements(driver, this);

	}

	public void searchSeleniumText(String text) {
		EnterText(searchBox, text,"searchBox" );

	}

	public String displayCurrent_Url() {
		
		String currentUrl=driver.getCurrentUrl();
		System.out.println( "Current URL is :"+currentUrl);
				return currentUrl;
	}

	public void ClickSearchBox() {
		
		searchBox.sendKeys(Keys.ENTER);
		}

    public String google_Title() {
		
		return driver.getTitle();
		 	 
	}
	
}
