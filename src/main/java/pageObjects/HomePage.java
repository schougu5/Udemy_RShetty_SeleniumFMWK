package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='nav-link btn btn-primary']")
    private WebElement checkoutButton;

    @FindBy(css = "button.btn.btn-info")
    private List<WebElement> addToCartButtons;

    @FindBy(xpath = "//button[@class='btn btn-danger']")
    private List<WebElement> removeButtons;

    public WebElement getCheckoutButton() {
        return checkoutButton;
    }

    public List<WebElement> getAddToCartButtons() {
        return addToCartButtons;
    }

    public List<WebElement> getRemoveButtons() {
        return removeButtons;
    }

    public void clickCheckout() {
        checkoutButton.click();
    }
}