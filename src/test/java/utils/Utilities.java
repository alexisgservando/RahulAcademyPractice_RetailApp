package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities 
{
	/*-------------------- VARIABLES ------------------------------ */
	private WebDriver driver;
	
	/*-------------------- CONSTRUCTOR ------------------------------ */
	public Utilities(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	/*-------------------- METHODS ------------------------------ */
	//Method to explicitly wait for an element to be loaded on the screen | Parameter: By
	public void explicitWaitCustomMethod(By by)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
}
