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

	@FindBy(xpath="test")
	List<WebElement> validateExistElement;

	//String typeValue=searchTextBox.getAttribute("type");
    /*
	public static final Target PANEL_WOMEN = Target.the("Panel woman")
			.located(By.xpath("//a[contains(@class,'sf-with-ul') and contains(@title,'Women')] "));
	public static final Target MENU_TOP = Target.the("Menu top")
			.located(By.xpath("(//a[contains(text(),'Tops') and contains(@title,'tops')])[1]"));
	public static final Target OPCION_SUETER = Target.the("Opcion sueter")
			.located(By.xpath("(//ul[contains(@class,'tree dynamized')]//a[contains(text(),'T-shirts')])[1]"));
	public static final Target BOTON_DISPONIBLE = Target.the("Boton disponible")
			.located(By.xpath("//span[contains(@class,'available-now')]"));*/

	/*
	private int tipo;

	public void setTipo(int t){
		tipo = t;
	}
	 */


	//Initializing the Page Objects:
	public LoginExerciseTestPage(){
		PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
	}

	public LoginExerciseTestPage searchText(){
		testUtil.waitVisibility(closePopUp);
		closePopUp.click();

		//testUtil.waitPresenceOfElement("test");
		/*boolean exist = validateExistElement.size() > 0;
		System.out.println("Exists element: " + exist);*/

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
