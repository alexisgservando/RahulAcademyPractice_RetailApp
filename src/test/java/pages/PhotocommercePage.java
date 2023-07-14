package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Utilities;

public class PhotocommercePage 
{
	/*-------------------- VARIABLES ------------------------------ */
	private WebDriver driver;
	Utilities utils;
	
	/*-------------------- CONSTRUCTOR ------------------------------ */
	public PhotocommercePage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	/*-------------------- LOCATORS ------------------------------ */
	private By shopName = By.cssSelector("h1[class='my-4']");
	private By appCard = By.tagName("app-card");
	private By appCardTitle = By.cssSelector(".card-title a");
	private By addButton = By.cssSelector(".card-footer button");
	private By checkoutButton = By.cssSelector(".nav-link.btn.btn-primary");
	
	/*-------------------- METHODS ------------------------------ */
	//Method to wait for an element to load | Search by By
	public void waitForPhotoCommercePageToLoad()
	{
		utils = new Utilities(driver);
		utils.explicitWaitCustomMethod(shopName);
		Assert.assertTrue(driver.findElement(shopName).isDisplayed(), "The page is not loaded yet");
	}
	
	//Method to get the products from the Photocommerce page and add to cart based on the products that we want to add 
	public void addProductsToCart(String[] expectedProducts)
	{
		List<WebElement> products = driver.findElements(appCard);
		for (WebElement product : products) 
		{
			for(int i = 0; i < expectedProducts.length; i++)
			{
				if(product.findElement(appCardTitle).getText().contains(expectedProducts[i])) //expectedProducts[i].contains(product.findElement(appCardTitle).getText())
				{
					product.findElement(addButton).click();
				}
			}
		}
	}
	
	//Method to click on the Checkout button
	public void clickCheckout()
	{
		driver.findElement(checkoutButton).click();
	}
	
	//Method to validate the number of products in the cart and compare the number with the actual number of products in expectedProducts variable
	public void validateProductsNumberInCart(String[] expectedProducts)
	{
		int numOfProducts = expectedProducts.length;
		String checkoutString = driver.findElement(checkoutButton).getText();
        String numberString = checkoutString.substring(checkoutString.indexOf("(") + 1, checkoutString.indexOf(")")).trim();
        int number = Integer.parseInt(numberString);
        Assert.assertEquals(number, numOfProducts);
        System.out.println("NUMBER OF PRODUCTS IN CART: " +number);
	}
	
	//After clicking the Continue Shopping button on the Checkout page, use this method to validate that the cart is clear | Checkout(0)
	public void validateCartIsEmpty()
	{
		String checkoutString = driver.findElement(checkoutButton).getText();
        String numberString = checkoutString.substring(checkoutString.indexOf("(") + 1, checkoutString.indexOf(")")).trim();
        int number = Integer.parseInt(numberString);
        Assert.assertEquals(number, 0);
        System.out.println("EMPTY CART - NUMBER OF PRODUCTS IN CART: " +number);
	}
}
