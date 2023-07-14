package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.Utilities;

public class LoginPage 
{
	/*-------------------- VARIABLES ------------------------------ */
	private WebDriver driver;
	Utilities utils;
	private static WebElement element = null;
	private static List<WebElement> elements = null;

	/*-------------------- CONSTRUCTOR ------------------------------ */
	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
	}

	/*-------------------- LOCATORS ------------------------------ */
	private By topIcon = By.cssSelector(".icon-circled");
	private By usernameField = By.cssSelector("#username");
	private By passwordField = By.cssSelector("#password");
	private By radioButtons = By.xpath("//input[@type='radio']");
	private By dropDown = By.cssSelector("select[class='form-control']");
	private By checkBox = By.cssSelector("#terms");
	private By SignInButton = By.cssSelector("#signInBtn");
	private By userAndPaswordString = By.cssSelector(".text-center.text-white");
	private By topUrl = By.xpath("//a[contains(text(),'Free Access to InterviewQues/ResumeAssistance/Mate')]");
	private By errorMessage = By.cssSelector(".alert.alert-danger.col-md-12");
	private By cancelButton = By.cssSelector("#cancelBtn");
	private By okayButton = By.cssSelector("#okayBtn");

	/*-------------------- METHODS ------------------------------ */
	//Method to validate that we are on the Login page
	public void validateLoginPage()
	{
		Assert.assertTrue(driver.findElement(topIcon).isDisplayed());
	}
	
	//Method to input the username value
	public void enterUsername(String username)
	{
		driver.findElement(usernameField).sendKeys(username);
	}

	//Method to input the password value
	public void enterPassword(String password)
	{
		driver.findElement(passwordField).sendKeys(password);
	}
	
	//Method to click on the radiobutton based on 2 options: Admin or User
	public void clickRadioButton(String option)
	{
		elements = driver.findElements(radioButtons);
		if(elements.size() >= 2)
		{
			/* ----Uncomment these 2 lines to check the values on the DOM for the radiobuttons
			System.out.println("First radio button: " +elements.get(0).getAttribute("value"));
			System.out.println("First radio button: " +elements.get(1).getAttribute("value"));
			 */

			switch (option) {
			case "admin":
				elements.get(0).click();
				break;
			case "user":
				elements.get(1).click();
				break;
			default:
				break;
			}
		}
		else
		{
			System.out.println("----less than 2 radiobuttons found");
		}
	} 
	
	//Method to pick a value from the dropdown
	public void selectOption(String option)
	{
		WebElement dropdownElement = driver.findElement(dropDown);
		Select dropdown = new Select(dropdownElement);
		switch (option) {
		case "Student":
			dropdown.selectByValue("stud");
			break;
		case "Teacher":
			dropdown.selectByValue("teach");
			break;
		case "Consultant":
			dropdown.selectByValue("consult");
		default:
			break;
		}
	}
	
	//Method to click on the Terms and Conditions checkbox
	public void clickCheckbox()
	{
		driver.findElement(checkBox).click();
	}
	
	//Method to click on the Sign In button
	public void clickSignInButton()
	{
		driver.findElement(SignInButton).click();
	}

	//Method to retrieve the username and password from the string on the screen | Returns an Array of strings (2 objects: username and password)
	public String[] getUsernameAndPasword()
	{
		element = driver.findElement(userAndPaswordString);
		String inputString = element.getText();
		
		// Extract the username and password
		String username = inputString.split("username is ")[1].split("and")[0].trim();
	    String password = inputString.split("Password is ")[1].split("\\)")[0].trim();

	    String[] credentials = {username, password};
	    return credentials;
	}

	//Method to get the username string from the getUsernameAndPassword() method | Returns an String
	public String validUsername() {
		String[] credentials = getUsernameAndPasword();
		String username = credentials[0];
		return username;
	}
	
	//Method to get the password string from the getUsernameAndPassword() method | Returns an String
	public String validPassword() {
		String[] credentials = getUsernameAndPasword();
		String password = credentials[1];
		return password;
	}
	
	//Method to click on the "Free Access to InterviewQues/ResumeAssistance/Material" URL
	public void clickURL()
	{
		driver.findElement(topUrl).click();
	}
	
	//Method to validate the error message after providing invalid credentials 
	public void validateErrorMessage()
	{
		utils = new Utilities(driver);
		utils.explicitWaitCustomMethod(errorMessage);
		Assert.assertTrue(driver.findElement(errorMessage).isDisplayed(), "The error message is not visible");
	}
	
	//Method to click on the Cancel button after selecting "User" from the radiobuttons
	public void clickCancelButton()
	{
		driver.findElement(cancelButton).click();
	}
	
	//Method to click on the Okay button after selecting "User" from the radiobuttons
	public void clickOkayButton()
	{
		driver.findElement(okayButton).click();
	}
}
