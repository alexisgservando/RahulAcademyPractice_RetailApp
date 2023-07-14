package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.Utilities;

public class DocumentsPage 
{
	/*-------------------- VARIABLES ------------------------------ */
	private WebDriver driver;
	Utilities utils;
	
	/*-------------------- CONSTRUCTOR ------------------------------ */
	public DocumentsPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	/*-------------------- LOCATORS ------------------------------ */
	private By registerUrl = By.linkText("Free Access to InterviewQues/ResumeAssistance/Material");
	
	/*-------------------- METHODS ------------------------------ */
	//Method to validate that the Documents page is loaded | Search by By  
	public void validateDocumentsPage()
	{
		Assert.assertTrue(driver.findElement(registerUrl).isDisplayed(), "The page is not loaded yet");
	}
	
	//Method to wait for an element to load | Search by By  
	public void waitForDocumentPageToLoad()
	{
		utils = new Utilities(driver);
		utils.explicitWaitCustomMethod(registerUrl);
	}
}
