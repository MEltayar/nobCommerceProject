package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;
import pages.RegisteredSuccessfullyPage;
import pages.Utils;

public class RegisterTest extends TestBase {
    //Taking object from HomePage
    HomePage homePage;

    //Taking object from UserRegisterationPage
    RegisterPage registerPage;

    RegisteredSuccessfullyPage registeredSuccessfully;

    // taking object readData from the jsonFileManager
    Utils.JsonFileManager readData = new Utils.JsonFileManager("src/test/java/data/RegisterTestData.json");

    @Test(description = "Verify that user register successfully")
    public void userRegister() {

        ////Creating an instance of the HomePage class and storing it in the homePage variable
        homePage = new HomePage(driver);
        //Navigate to home page
        homePage.navigateToHomePage();
        //Click on the register button
        homePage.clickRegButton();
        //Creating an instance of the RegisterPage class and storing it in the registerPage variable
        registerPage = new RegisterPage(driver);
        //Fill all the register details
        registerPage.userRegister(readData.getTestData("Gender"), readData.getTestData("firstName"), readData.getTestData("lastName"), readData.getTestData("dayOfBirth"), readData.getTestData("monthOfBirth"),
                readData.getTestData("yearOfBirth"), readData.getTestData("Email"), readData.getTestData("companyName"), readData.getTestData("Password"),
                readData.getTestData("confirmPassword"));
        registeredSuccessfully = new RegisteredSuccessfullyPage(driver);
        //Assert that user register successfully
        Assert.assertEquals(registeredSuccessfully.expectedRegisterSuccessfullyMessage, registeredSuccessfully.actualRegisterSuccessfullyMessage);
    }
}
