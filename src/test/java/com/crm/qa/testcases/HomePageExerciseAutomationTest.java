package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginExerciseTestAutomationPage;
import com.crm.qa.pages.LoginExerciseTestPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageExerciseAutomationTest extends TestBase {
	LoginExerciseTestAutomationPage loginExerciseTestAutomationPage;

	public HomePageExerciseAutomationTest() {
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() {
		initialization();
	}

	@Test(priority=1)
	public void searchTestValidation(){
		loginExerciseTestAutomationPage = new LoginExerciseTestAutomationPage();
		loginExerciseTestAutomationPage.searchText();
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
