package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

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

	Wait waitElement;

	TestUtil testUtil;

	//Initializing the Page Objects:
	public LoginExercisePage(){
		PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
	}

	public LoginExercisePage login(String login, String pwd){
		testUtil.waitVisibility(username);
		username.sendKeys(login);

		testUtil.waitVisibility(password);
		password.sendKeys(pwd);
		loginButton.click();
		return new LoginExercisePage();
	}
}
