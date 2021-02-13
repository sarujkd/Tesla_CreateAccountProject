package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseTest;

public class CreateAccountPage extends BaseTest{

	@FindBy(xpath="(//a[contains(text(),'Tesla Account')])[1]")
	WebElement teslaAccount;
	
	@FindBy(id="form-button-create")
	WebElement createAccount ;
	//first_name
	
	@FindBy(name="first_name")
	WebElement FirstName ;
	
	@FindBy(css="#form-input-last_name")
	WebElement lastName ;
	
	@FindBy(css="#form-input-email")
	WebElement emailAddress ;
	
	@FindBy(id="form-input-password")
	WebElement password ;
	
	@FindBy(xpath="(//label[@class='tds-label tds-label--checkbox'])[1]")
	WebElement privacyCheckBox ;
	
	@FindBy(css="#form-submit-continue")
	WebElement createAccntBtn ;
	

	
	
	public CreateAccountPage(){
	
	PageFactory.initElements(driver, this);
		
	}
	
	public void Click_teslaAccountLink() {
		teslaAccount.click();
		
	}
	
	public void Click_createAccountBtn() {
		createAccount.click();
		
	}
	
	public String CreateAccountPageTitle() {
			return driver.getTitle();
			
	}
	
	public void AddFirstName(String firstName){
		 
		 FirstName.clear();
		 FirstName.sendKeys(firstName);
		
	 }

	public void AddLastName(String LastName){
		 
		 lastName.clear();
		 lastName.sendKeys(LastName);
		
	 }

	public void AddEmailAddress(String email){
		 
		 emailAddress.clear();
		 emailAddress.sendKeys(email);
		
	 }
	
	public void AddPassword(String pwd){
		 
		password.clear();
		password.sendKeys(pwd);
		
	 }
	public void Click_PrivacyCheckBox() {
		privacyCheckBox.click();
	
}

	 public void Click_createAccntBtn(){
		 createAccntBtn.click();
	 }
}







