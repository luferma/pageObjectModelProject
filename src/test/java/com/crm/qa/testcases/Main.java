package com.crm.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String binPath = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver", binPath + "//Repository//chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://www.google.com");

		long startTime = System.currentTimeMillis();


		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		try
		{

			/*WebElement foo = wait.until(new Function<WebDriver, WebElement>()
					{
					  public WebElement apply(WebDriver driver) {
					  return driver.findElement(By.name("btnK"));
					}
					});
			*/

			WebElement element =  driver.findElement(By.name("btnK"));
			//wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		catch (Exception e) {

			e.printStackTrace();
		}

		finally
		{

			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			System.out.println(elapsedTime);

		}




	}

}
