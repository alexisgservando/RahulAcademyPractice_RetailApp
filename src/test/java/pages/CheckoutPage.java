package pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Utilities;
import java.util.stream.Collectors;

public class CheckoutPage 
{
	/*-------------------- VARIABLES ------------------------------ */
	private WebDriver driver;
	Utilities utils;

	/*-------------------- CONSTRUCTOR ------------------------------ */
	public CheckoutPage(WebDriver driver) 
	{
		this.driver = driver;
	}

	/*-------------------- LOCATORS ------------------------------ */
	private By tableClass = By.cssSelector(".table.table-hover");
	private By numberOfRows = By.xpath("//tbody/tr/td/div/div/h4/a");
	private By continueShoppingButton = By.cssSelector("button[class='btn btn-default']");
	private By checkoutButton = By.cssSelector("button[class='btn btn-success']");

	/*-------------------- METHODS ------------------------------ */
	//Method to wait for an element to load | Search by By  
	public void waitForCheckoutPageToLoad()
	{
		utils = new Utilities(driver);
		utils.explicitWaitCustomMethod(tableClass);
		Assert.assertTrue(driver.findElement(tableClass).isDisplayed(), "The page is not loaded yet");
	}

	// Method to capture the first column of the table and store it in a List | Product names
	public void validateProductsInTable(String[] expectedProducts) {
	    List<WebElement> rowElements = driver.findElements(numberOfRows);
	    System.out.println("Number of Rows: " + rowElements.size());

	    List<String> actualProducts = new ArrayList<>();
	    for (WebElement element : rowElements) 
	    {
	        String text = element.getText();
	        actualProducts.add(text);
	        System.out.println(text);
	    }

	    List<Object> sortedExpectedProducts = Arrays.stream(expectedProducts).sorted().collect(Collectors.toList());
	    List<Object> sortedActualProducts = actualProducts.stream().sorted().collect(Collectors.toList());
	    Assert.assertEquals(sortedActualProducts, sortedExpectedProducts, "Mismatch between actual products and expected products.");
	}
	
	//Method to click the Continue Shopping button
	public void clickContinueShoppingButton()
	{
		driver.findElement(continueShoppingButton).click();
	}
	
	//Method to click on Checkout button
	public void clickCheckoutButton()
	{
		driver.findElement(checkoutButton).click();
	}
}
