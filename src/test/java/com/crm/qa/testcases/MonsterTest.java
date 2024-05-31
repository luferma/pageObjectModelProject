package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MonsterTest extends TestBase {
	HorsePage horsePage;
	SharkPage sharkPage;
	DragonPage dragonPage;
	MousePage mousePage;
	SnakePage snakePage;

	public MonsterTest() {
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
	public void creationTest(){
		horsePage = new HorsePage();
		sharkPage = new SharkPage();
		dragonPage = new DragonPage();
		mousePage = new MousePage();
		snakePage = new SnakePage();

		horsePage.addMonster();
		sharkPage.addMonster();
		dragonPage.addMonster();
		mousePage.addMonster();
		snakePage.addMonster();
	}

	@Test(priority=2)
	public void deleteTest(){
		horsePage = new HorsePage();
		sharkPage = new SharkPage();
		dragonPage = new DragonPage();
		mousePage = new MousePage();
		snakePage = new SnakePage();

		horsePage.deleteMonster();
		sharkPage.deleteMonster();
		dragonPage.deleteMonster();
		mousePage.deleteMonster();
		snakePage.deleteMonster();
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
