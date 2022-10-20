package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(name = "username")
    public WebElement usernameField;
    @FindBy(name = "password")
    public WebElement passwordField;
    @FindBy(xpath = "//button")
    public WebElement loginButton;
    @FindBy(xpath = "//img[@alt='profile picture']")
    public WebElement profilePicture;
    @FindBy(xpath = "//p[text()='Invalid credentials']")
    public WebElement errorLabel;
    @FindBy(xpath = "//span[text()='Required']")
    public WebElement requiredLabel;
    @FindBy(xpath = "//span[contains(@class, 'userdropdown')]")
    public WebElement userDropdown;
    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement optLogout;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void type(WebElement element, String value){
        element.sendKeys(value);
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }

    public void login(String user, String pass){
        type(usernameField, user);
        type(passwordField, pass);
        clickOnLoginButton();
    }

    public void logout(){
        userDropdown.click();
        optLogout.click();
    }

    public Boolean isOnHomePage() {
        return profilePicture.isDisplayed();
    }
    public Boolean wrongCredentials() { return errorLabel.isDisplayed(); }
    public Boolean emptyCredentials() { return requiredLabel.isDisplayed(); }
    public Boolean loginButton() { return loginButton.isDisplayed(); }
}
