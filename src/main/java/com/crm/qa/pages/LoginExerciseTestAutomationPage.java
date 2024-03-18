package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class LoginExerciseTestAutomationPage extends TestBase{

	//Page Factory - OR:
	@FindBy(xpath="//button[contains(text(),'Start')]")
	WebElement buttonStart;

	@FindBy(id="loading")
	WebElement progressBar;

	@FindBy(id="loading")
	List<WebElement> progressBarList;

	@FindBy(xpath="//h4[contains(text(),'Hello World!')]")
	WebElement textValidation;

	@FindBy(xpath="//article[contains(@class,'display-flex')]//div//h3")
	List<WebElement> resultSearchText;

	TestUtil testUtil;

	@FindBy(xpath="test")
	List<WebElement> validateExistElement;

	//Initializing the Page Objects:
	public LoginExerciseTestAutomationPage(){
		PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
	}

	public LoginExerciseTestAutomationPage searchText(){
		testUtil.waitVisibility(buttonStart);
		buttonStart.click();
		testUtil.waitVisibility(progressBar);
		System.out.println("Value: " + progressBarList.size());
		Assert.assertTrue(progressBarList.size()>0);

		boolean visibility = true;
		try {
			testUtil.waitIsNotVisible(progressBar);
		}catch (NoSuchElementException e){
			visibility = true;
			System.out.println("Element: " + e.getMessage());
		}
		System.out.println("Value 1: " + progressBarList.size());
		Assert.assertTrue(visibility);
		testUtil.waitVisibility(textValidation);

		Assert.assertEquals("Hello World!", textValidation.getText());
		return new LoginExerciseTestAutomationPage();
	}
}
