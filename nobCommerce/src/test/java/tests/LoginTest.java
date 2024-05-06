package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class LoginTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    LogedInSuccessfully logedIn;
    Utils.JsonFileManager readData = new Utils.JsonFileManager("src/test/java/data/LoginTestData.json");

    @Test
    public void setLoginCredentials() {
        //Creating an instance of the HomePage class and storing it in the homePage variable
        homePage = new HomePage(driver);
        //Navigate to home page
        homePage.navigateToHomePage();
        //Click on the Login button
        homePage.clickLoginButton();
        //creating an instance of the LoginPage class and storing it in the loginPage variable
        loginPage = new LoginPage(driver);
        //Enter the Login credentials
        loginPage.loginCredentials(readData.getTestData("Email"), readData.getTestData("Password"));
        logedIn = new LogedInSuccessfully(driver);
        //Assert that user login successfully
        Assert.assertEquals("Log out", logedIn.expectedLoginSuccessfully);
    }
}
