package tests;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;
import pages.RegisteredSuccessfullyPage;
import pages.Utils;

public class RegisterTest extends TestBase{
    //Taking object from HomePage
    HomePage homePage;

    //Taking object from UserRegisterationPage
    RegisterPage registerPage;

    RegisteredSuccessfullyPage registeredSuccessfully;



    // taking object readData from the jsonFileManager
    Utils.JsonFileManager readData = new Utils.JsonFileManager("src/test/java/data/RegisterTestData.json");

    //register successfully message


    @Test(description = "Verify that user register successfully")
    public void userRegister(){

        homePage = new HomePage(driver);
        homePage.clickRegButton();
        registerPage = new RegisterPage(driver);
        registerPage.userRegister(readData.getTestData("Gender"),readData.getTestData("firstName"),readData.getTestData("lastName"),readData.getTestData("dayOfBirth"),readData.getTestData("monthOfBirth"),
        readData.getTestData("yearOfBirth"),readData.getTestData("Email"),readData.getTestData("companyName"),readData.getTestData("Password"),
                readData.getTestData("confirmPassword"));
        registeredSuccessfully = new RegisteredSuccessfullyPage(driver);
      Assert.assertEquals(registeredSuccessfully.expectedRegisterSuccessfullyMessage, registeredSuccessfully.actualRegisterSuccessfullyMessage);
    }
}
