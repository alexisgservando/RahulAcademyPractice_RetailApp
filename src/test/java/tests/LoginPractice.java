package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.CheckoutPage;
import pages.DeliveryLocationPage;
import pages.DocumentsPage;
import pages.LoginPage;
import pages.PhotocommercePage;

public class LoginPractice 
{
	//Variables
	private WebDriver driver;
	private LoginPage loginPage;
	private PhotocommercePage photoCommercePage;
	
	@BeforeTest
	public void setUp()
	{
		//Initializing the webdriver
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://www.rahulshettyacademy.com/loginpagePractise/");
	    driver.manage().window().maximize();
	    loginPage = new LoginPage(driver);
	}

	@Test(description = "Clicking the URL at the top right corner of the Login page")
	public void TC01()
	{
		loginPage.validateLoginPage();
		loginPage.clickURL();
		DocumentsPage documentsPage = new DocumentsPage(driver);
		documentsPage.waitForDocumentPageToLoad();
		documentsPage.validateDocumentsPage();
	}
	
	@Test(description = "Login test | Role: Admin | Happy path with valid credentials")
	public void TC02()
	{
		loginPage.validateLoginPage();
		loginPage.enterUsername(loginPage.validUsername());
		loginPage.enterPassword(loginPage.validPassword());
		loginPage.clickRadioButton("admin");
		loginPage.selectOption("Teacher");
		loginPage.clickCheckbox();
		loginPage.clickSignInButton();
		photoCommercePage = new PhotocommercePage(driver);
		photoCommercePage.waitForPhotoCommercePageToLoad();
	}
	
	@Test(description = "Login test | Role: Admin | Invalid credentials")
	public void TC03()
	{
		String invalidUsername = "invalidUser";
		String invalidPassword = "invalidPass";
		loginPage.validateLoginPage();
		loginPage.enterUsername(invalidUsername);
		loginPage.enterPassword(invalidPassword);
		loginPage.clickRadioButton("admin");
		loginPage.selectOption("Teacher");
		loginPage.clickCheckbox();
		loginPage.clickSignInButton();
		loginPage.validateErrorMessage();
	}
	
	@Test(description = "Login test | Role: User | Valid credentials | Option: Cancel")
	public void TC04()
	{
		loginPage.validateLoginPage();
		loginPage.enterUsername(loginPage.validUsername());
		loginPage.enterPassword(loginPage.validPassword());
		loginPage.clickRadioButton("user");
		loginPage.clickCancelButton();
		loginPage.validateLoginPage();
	}

	@Test(description = "Login test | Role: User | Valid credentials | Option: Okay")
	public void TC05()
	{
		loginPage.validateLoginPage();
		loginPage.enterUsername(loginPage.validUsername());
		loginPage.enterPassword(loginPage.validPassword());
		loginPage.clickRadioButton("user");
		loginPage.clickOkayButton();
		loginPage.validateLoginPage();
	}
	
	@Test(dependsOnMethods = "TC02", description = "TC02 runs first | Add 1 product to cart: iphone X")
	public void TC06() 
	{
		String[] expectedProducts = {"iphone X"};
		photoCommercePage.addProductsToCart(expectedProducts);
		photoCommercePage.validateProductsNumberInCart(expectedProducts);
	}
	
	@Test(dependsOnMethods = "TC02", description = "TC02 runs first | Add 1 product to cart: Samsung Note 8")
	public void TC07() 
	{
		String[] expectedProducts = {"Samsung Note 8"};
		photoCommercePage.addProductsToCart(expectedProducts);
		photoCommercePage.validateProductsNumberInCart(expectedProducts);
	}
	
	@Test(dependsOnMethods = "TC02", description = "TC02 runs first | Add 1 product to cart: Nokia Edge")
	public void TC08() 
	{
		String[] expectedProducts = {"Nokia Edge"};
		photoCommercePage.addProductsToCart(expectedProducts);
		photoCommercePage.validateProductsNumberInCart(expectedProducts);
	}
	
	@Test(dependsOnMethods = "TC02", description = "TC02 runs first | Add 1 product to cart: Blackberry")
	public void TC09() 
	{
		String[] expectedProducts = {"Blackberry"};
		photoCommercePage.addProductsToCart(expectedProducts);
		photoCommercePage.validateProductsNumberInCart(expectedProducts);
	}
	
	@Test(dependsOnMethods = "TC02", description = "TC02 runs first | Add 2 products to cart: iphone X, Samsung Note 8")
	public void TC10() 
	{
		String[] expectedProducts = {"iphone X", "Samsung Note 8"};
		photoCommercePage.addProductsToCart(expectedProducts);
		photoCommercePage.validateProductsNumberInCart(expectedProducts);
	}
	
	@Test(dependsOnMethods = "TC02", description = "TC02 runs first | Add 2 products to cart: Nokia Edge, Blackberry")
	public void TC11() 
	{
		String[] expectedProducts = {"Nokia Edge", "Blackberry"};
		photoCommercePage.addProductsToCart(expectedProducts);
		photoCommercePage.validateProductsNumberInCart(expectedProducts);
	}
	
	@Test(dependsOnMethods = "TC02", description = "TC02 runs first | Add 2 products to cart: Samsung Note 8, Blackberry")
	public void TC12() 
	{
		String[] expectedProducts = {"Samsung Note 8", "Blackberry"};
		photoCommercePage.addProductsToCart(expectedProducts);
		photoCommercePage.validateProductsNumberInCart(expectedProducts);
	}
	
	@Test(dependsOnMethods = "TC02", description = "TC02 runs first | Add 2 products to cart: Blackberry, Nokia Edge (Backwards order)")
	public void TC13() 
	{
		String[] expectedProducts = {"Blackberry", "Nokia Edge"};
		photoCommercePage.addProductsToCart(expectedProducts);
		photoCommercePage.validateProductsNumberInCart(expectedProducts);
	}
	
	@Test(dependsOnMethods = "TC02", description = "TC02 runs first | Add 3 products to cart: iPhone X, Samsung Note 8, Blackberry")
	public void TC14() 
	{
		String[] expectedProducts = {"iphone X", "Samsung Note 8", "Blackberry"};
		photoCommercePage.addProductsToCart(expectedProducts);
		photoCommercePage.validateProductsNumberInCart(expectedProducts);
	}
	
	@Test(dependsOnMethods = "TC02", description = "TC02 runs first | Add 4 products to cart: iPhone X, Samsung Note 8, Nokia Edge, Blackberry (Backwards order)")
	public void TC15() 
	{
		String[] expectedProducts = {"Blackberry", "Nokia Edge", "Samsung Note 8", "iphone X", };
		photoCommercePage.addProductsToCart(expectedProducts);
		photoCommercePage.validateProductsNumberInCart(expectedProducts);
	}
	
	@Test(dependsOnMethods = "TC02", description = "TC02 runs first | Add 4 products to cart: iPhone X, Samsung Note 8, Nokia Edge, Blackberry")
	public void TC16() 
	{
		String[] expectedProducts = {"iphone X", "Samsung Note 8", "Nokia Edge" ,"Blackberry"};
		photoCommercePage.addProductsToCart(expectedProducts);
		photoCommercePage.validateProductsNumberInCart(expectedProducts);
	}
	
	@Test(dependsOnMethods = "TC02", description = "TC02 runs first | E2E | Add 4 products to cart: iPhone X, Samsung Note 8, Nokia Edge, Blackberry | Continue Shopping button at the checkout page")
	public void TC17() 
	{
		String[] expectedProducts = {"iphone X", "Samsung Note 8", "Nokia Edge" ,"Blackberry"};
		photoCommercePage.addProductsToCart(expectedProducts);
		photoCommercePage.validateProductsNumberInCart(expectedProducts);
		photoCommercePage.clickCheckout();
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.waitForCheckoutPageToLoad();
		checkoutPage.validateProductsInTable(expectedProducts);
		checkoutPage.clickContinueShoppingButton();
		photoCommercePage.validateCartIsEmpty();
	}
	
	@Test(dependsOnMethods = "TC02", description = "TC02 runs first | E2E | Add 4 products to cart: iPhone X, Samsung Note 8, Nokia Edge, Blackberry | Purchase button at the checkout page")
	public void TC18() 
	{
		String[] expectedProducts = {"iphone X", "Samsung Note 8", "Nokia Edge" ,"Blackberry"};
		photoCommercePage.addProductsToCart(expectedProducts);
		photoCommercePage.validateProductsNumberInCart(expectedProducts);
		photoCommercePage.clickCheckout();
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.waitForCheckoutPageToLoad();
		checkoutPage.validateProductsInTable(expectedProducts);
		checkoutPage.clickCheckoutButton();
		
		DeliveryLocationPage deliveryPage = new DeliveryLocationPage(driver);
		deliveryPage.clickPurchaseAndValidateSuccessMessage();
	}
	
	@AfterTest
	public void tearDown()
	{
		//driver.quit();
		//driver.close();
	}
}
