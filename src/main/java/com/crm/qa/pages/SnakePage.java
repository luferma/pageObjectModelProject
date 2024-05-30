package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SnakePage extends TestBase{

	//Page Factory - OR:
	@FindBy(xpath="//div[@data-testid='monster-5']")
	WebElement snakeImage;

	@FindBy(xpath="//input[@name='name']")
	WebElement nameInput;

	@FindBy(xpath="//input[@name='hp']")
	WebElement hPInput;

	@FindBy(xpath="//input[@name='attack']")
	WebElement attackInput;

	@FindBy(xpath="//input[@name='defense']")
	WebElement defenseInput;

	@FindBy(xpath="//input[@name='speed']")
	WebElement speedInput;

	@FindBy(xpath="//button[@data-testid='btn-create-monster']")
	WebElement createButton;

	@FindBy(xpath="//p[contains(text(),'Mouse')]")
	WebElement snakeCreated;

	/*@FindBy(xpath="//article[contains(@class,'display-flex')]//div//h3")
	List<WebElement> resultSearchText;*/

	TestUtil testUtil;

	//Initializing the Page Objects:
	public SnakePage(){
		PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
	}

	public SnakePage addMonster(){
		testUtil.waitVisibility(snakeImage);
		snakeImage.click();

		nameInput.sendKeys("Mouse");
		hPInput.sendKeys(String.valueOf(1));
		attackInput.sendKeys(String.valueOf(1));
		defenseInput.sendKeys(String.valueOf(1));
		speedInput.sendKeys(String.valueOf(1));

		createButton.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", snakeCreated);
		testUtil.waitVisibility(snakeCreated);
		Assert.assertTrue(snakeCreated.isDisplayed());
		return new SnakePage();
	}
}
