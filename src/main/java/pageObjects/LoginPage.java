package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#username")
    private WebElement username;

    @FindBy(css = "#password")
    private WebElement password;

    @FindBy(xpath = "//input[@value='user']")
    private WebElement userRadioButton;

    @FindBy(id = "okayBtn")
    private WebElement okayButton;

    @FindBy(id = "terms")
    private WebElement termsCheckbox;

    @FindBy(css = "select[class='form-control']")
    private WebElement userTypeDropdown;

    @FindBy(id = "signInBtn")
    private WebElement signInButton;

    public void enterUsername(String user) {
        username.sendKeys(user);
    }

    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    public void selectUserRadioButton() {
        userRadioButton.click();
    }

    public WebElement getOkayButton() {
        return okayButton;
    }

    public void acceptTerms() {
        termsCheckbox.click();
    }

    public void selectUserType(String userType) {
        Select select = new Select(userTypeDropdown);
        select.selectByVisibleText(userType);
    }

    public void clickSignIn() {
        signInButton.click();
    }
}