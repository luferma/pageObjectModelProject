package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginExercisePage;
import com.crm.qa.pages.LoginExerciseTestPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageExerciseTest extends TestBase {
	LoginExerciseTestPage loginExerciseTestPage;

	public HomePageExerciseTest() {
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
		loginExerciseTestPage = new LoginExerciseTestPage();
		loginExerciseTestPage.searchText();
		loginExerciseTestPage.listValidation();
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
