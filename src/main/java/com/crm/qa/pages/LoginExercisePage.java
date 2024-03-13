package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

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

	@FindBy(xpath="//select[contains(@class,'product_sort_container')]")
	WebElement searchBox;

	@FindBy(id="add-to-cart-sauce-labs-onesie")
	WebElement element1;

	@FindBy(id="add-to-cart-sauce-labs-bike-light")
	WebElement element2;

	@FindBy(xpath="//a[contains(@class,'shopping_cart_link')]")
	WebElement shoppingCar;

	@FindBy(id="checkout")
	WebElement checkoutButton;

	@FindBy(id="react-burger-menu-btn")
	WebElement menuBurgerButton;

	@FindBy(id="about_sidebar_link")
	WebElement menuAbout;

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

	public void buyElements(){
		testUtil.waitVisibility(searchBox);
		Select objSelect =new Select(searchBox);
		objSelect.selectByVisibleText("Price (low to high)");

		testUtil.waitVisibility(element1);
		element1.click();
		element2.click();

		shoppingCar.click();

		testUtil.waitClickable(checkoutButton);
		checkoutButton.click();

		menuBurgerButton.click();
		menuAbout.click();
	}
}
