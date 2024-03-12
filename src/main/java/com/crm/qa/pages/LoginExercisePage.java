package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginExercisePage extends TestBase{

	//Page Factory - OR:
	@FindBy(id="user-name")
	WebElement username;

	@FindBy(id="password")
	WebElement password;

	@FindBy(id="login-button")
	WebElement loginButton;

	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;

	//Initializing the Page Objects:
	public LoginExercisePage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}

	public LoginExercisePage login(String login, String pwd){
		username.sendKeys(login);
		password.sendKeys(pwd);
		loginButton.click();
		    	
		return new LoginExercisePage();
	}
	
}
