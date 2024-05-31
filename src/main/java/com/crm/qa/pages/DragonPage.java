package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DragonPage extends TestBase{

	//Page Factory - OR:
	@FindBy(xpath="//div[@data-testid='monster-3']")
	WebElement dragonImage;

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

	@FindBy(xpath="//p[text()='Dragon']")
	WebElement dragonCreated;

	@FindBy(xpath="//button[@data-testid='btn-delete']")
	WebElement deleteButton;

	@FindBy(xpath="//p[text()='There are no monsters']")
	WebElement monsterDeletedMessage;
	/*@FindBy(xpath="//article[contains(@class,'display-flex')]//div//h3")
	List<WebElement> resultSearchText;*/

	TestUtil testUtil;

	//Initializing the Page Objects:
	public DragonPage(){
		PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
	}

	public DragonPage addMonster(){
		testUtil.waitVisibility(dragonImage);
		dragonImage.click();

		nameInput.sendKeys("Dragon");
		hPInput.sendKeys(String.valueOf(1));
		attackInput.sendKeys(String.valueOf(1));
		defenseInput.sendKeys(String.valueOf(1));
		speedInput.sendKeys(String.valueOf(1));

		createButton.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", dragonCreated);
		testUtil.waitVisibility(dragonCreated);
		Assert.assertTrue(dragonCreated.isDisplayed());
		return new DragonPage();
	}

	public DragonPage deleteMonster(){
		testUtil.waitVisibility(dragonImage);
		dragonImage.click();

		nameInput.sendKeys("Dragon");
		hPInput.sendKeys(String.valueOf(1));
		attackInput.sendKeys(String.valueOf(1));
		defenseInput.sendKeys(String.valueOf(1));
		speedInput.sendKeys(String.valueOf(1));

		createButton.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", dragonCreated);
		testUtil.waitVisibility(dragonCreated);
		Assert.assertTrue(dragonCreated.isDisplayed());

		deleteButton.click();
		Assert.assertTrue(monsterDeletedMessage.isDisplayed());

		return new DragonPage();
	}
}
