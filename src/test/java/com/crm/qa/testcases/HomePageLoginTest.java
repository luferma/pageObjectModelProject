package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginExercisePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageLoginTest extends TestBase {
	LoginExercisePage loginExercisePage;

	public HomePageLoginTest() {
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
	public void loginTest(){
		loginExercisePage = new LoginExercisePage();
		loginExercisePage.login(prop.getProperty("username"), prop.getProperty("password"));
		loginExercisePage.buyElements();
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
