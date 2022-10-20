package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Credentials;

public class LoginTest extends BaseTest{

    @Test
    public void loginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(Credentials.USER, Credentials.PASS);
        Assert.assertTrue(loginPage.isOnHomePage());
    }
    @Test
    public void loginWithWrongCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(Credentials.WRONGUSER, Credentials.WRONGPASS);
        Assert.assertTrue(loginPage.wrongCredentials());
    }
    @Test
    public void loginWithEmptyUsername() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", Credentials.PASS);
        Assert.assertTrue(loginPage.emptyCredentials());
    }
    @Test
    public void loginWithEmptyPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(Credentials.USER, "");
        Assert.assertTrue(loginPage.emptyCredentials());
    }
    @Test
    public void logout() {
        LoginPage loginPage = new LoginPage(driver);
        loginWithValidCredentials();
        loginPage.logout();
        Assert.assertTrue(loginPage.loginButton());
    }
}
