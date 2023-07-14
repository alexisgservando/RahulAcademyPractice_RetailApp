package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeliveryLocationPage {
    /*-------------------- VARIABLES ------------------------------ */
    private WebDriver driver;

    /*-------------------- CONSTRUCTOR ------------------------------ */
    public DeliveryLocationPage(WebDriver driver) {
        this.driver = driver;
    }

    /*-------------------- LOCATORS ------------------------------ */
    //private By countryField = By.cssSelector("#country");									-- Uncomment this to use the Location field and send a value (currently not needed)
    //private By termsCheckbox = By.cssSelector("label[for='checkbox2']");					-- Uncomment this to click on the terms & conditions checkbox (currently not needed)
    private By purchaseButton = By.cssSelector("input[value='Purchase']");
    private By successMessage = By.cssSelector("div[class='alert alert-success alert-dismissible'] strong");

    /*-------------------- METHODS ------------------------------ */
    // Method to click on the Purchase button and validate the success message
    public void clickPurchaseAndValidateSuccessMessage() {
        WebElement purchaseButtonElement = driver.findElement(purchaseButton);
        purchaseButtonElement.click();

        WebElement message = driver.findElement(successMessage);
        System.out.println(" ****MESSAGE: **** " +message.getText());

        // Assert that the success message contains the expected text | Expected text from DOM = Success!
        String expectedText = "Success!";
        String actualText = message.getText();
        assert actualText.equals(expectedText) : "Expected text not found on the screen.";
    }
}
