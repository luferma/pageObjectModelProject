package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HorsePage extends TestBase{

	//Page Factory - OR:
	@FindBy(xpath="//div[@data-testid='monster-1']")
	WebElement horseImage;

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

	@FindBy(xpath="//p[contains(text(),'Horse')]")
	WebElement horseCreated;

	@FindBy(xpath="//button[@data-testid='btn-delete']")
	WebElement deleteMonster;

	@FindBy(xpath="//p[contains(text(),'There are no monsters')]")
	WebElement noMonsters;


	/*@FindBy(xpath="//article[contains(@class,'display-flex')]//div//h3")
	List<WebElement> resultSearchText;*/

	TestUtil testUtil;

	//Initializing the Page Objects:
	public HorsePage(){
		PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
	}

	public HorsePage addMonster(){
		testUtil.waitVisibility(horseImage);
		horseImage.click();

		nameInput.sendKeys("Horse");
		hPInput.sendKeys(String.valueOf(1));
		attackInput.sendKeys(String.valueOf(1));
		defenseInput.sendKeys(String.valueOf(1));
		speedInput.sendKeys(String.valueOf(1));

		createButton.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", horseCreated);
		testUtil.waitVisibility(horseCreated);
		Assert.assertTrue(horseCreated.isDisplayed());
		return new HorsePage();
	}

	public HorsePage deleteMonster(){
		testUtil.waitVisibility(horseImage);
		horseImage.click();

		nameInput.sendKeys("Horse");
		hPInput.sendKeys(String.valueOf(1));
		attackInput.sendKeys(String.valueOf(1));
		defenseInput.sendKeys(String.valueOf(1));
		speedInput.sendKeys(String.valueOf(1));

		createButton.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", horseCreated);
		testUtil.waitVisibility(horseCreated);
		Assert.assertTrue(horseCreated.isDisplayed());

		deleteMonster.click();
		Assert.assertTrue(noMonsters.isDisplayed());

		return new HorsePage();
	}

}
