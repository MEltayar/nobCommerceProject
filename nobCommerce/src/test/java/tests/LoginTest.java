package tests;

import io.qameta.allure.Step;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class LoginTest extends TestBase{

    HomePage homePage;
    LoginPage loginPage;
    LogedInSuccessfully logedIn;
    Utils.JsonFileManager readData = new Utils.JsonFileManager("src/test/java/data/LoginTestData.json");

    @Test
    public void setLoginCredentials()
    {
        homePage= new HomePage(driver);
        homePage.clickLoginButton();
        loginPage= new LoginPage(driver);
        loginPage.loginCredentials(readData.getTestData("Email"),readData.getTestData("Password"));
        logedIn = new LogedInSuccessfully(driver);
        Assert.assertEquals("Log out", logedIn.expectedLoginSuccessfully);
    }
}
