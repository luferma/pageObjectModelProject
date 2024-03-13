package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class LoginExerciseTestPage extends TestBase{

	//Page Factory - OR:
	@FindBy(xpath="//span[contains(text(),'Search')]")
	WebElement searchText;

	@FindBy(xpath="//span[contains(@class,'boxzilla-close-icon')]")
	WebElement closePopUp;

	@FindBy(xpath="//input[contains(@type,'search')]")
	WebElement searchEnterText;

	@FindBy(xpath="//article[contains(@class,'display-flex')]//div//h3")
	List<WebElement> resultSearchText;

	TestUtil testUtil;

	//Initializing the Page Objects:
	public LoginExerciseTestPage(){
		PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
	}

	public LoginExerciseTestPage searchText(){
		testUtil.waitVisibility(closePopUp);
		closePopUp.click();

		testUtil.waitVisibility(searchText);
		searchText.click();

		searchEnterText.click();
		searchEnterText.sendKeys("Test");
		searchEnterText.sendKeys(Keys.ENTER);

		return new LoginExerciseTestPage();
	}

	public void listValidation(){
		boolean flag = false;
		for(WebElement element: resultSearchText){
			System.out.println("Text: " + element.getText());
			if(element.getText().contains("TEST-DRIVEN")){
				flag=true;
				break;
			}
		}

		Assert.assertTrue(flag);
		Assert.assertEquals("True","True");
	}
}
