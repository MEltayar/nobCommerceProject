package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Objects;

public class RegisterPage extends PageBase{

    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    Select select;
    Utils.JsonFileManager readData = new Utils.JsonFileManager("src/test/java/data/RegisterTestData.json");

    public By maleGender = By.id("gender-male");
    public By femaleGender = By.id("gender-female");
    public By firstName = By.id("FirstName");
    public By lastName = By.id("LastName");
    public By dayOfBirth = By.xpath("//select[@name='DateOfBirthDay']");
    public By monthOfBirth = By.xpath("//select[@name='DateOfBirthMonth']");
    public By yearOfBirth = By.xpath("//select[@name='DateOfBirthYear']");
    public By Email = By.id("Email");
    public By companyName = By.id("Company");
    public By Password = By.id("Password");
    public By confirmPassword = By.id("ConfirmPassword");
    public By registerButton = By.id("register-button");

    //method to select gender
    public void selectGender(String gender){
        gender = readData.getTestData("Gender");
        if(gender.equals("Male")) {
            Utils.clickButton(driver,maleGender);
        } else if (gender.equals("Female")) {
            Utils.clickButton(driver,femaleGender);

        }
    }
    //method to register user with data driven
    public void userRegister(String Gender, String First_Name,String Last_Name,String Day_Of_Birth, String Month_Of_Birth, String Year_Of_Birth,String email,String Company_Name
                            ,String password,String Confirm_Password)
    {
        selectGender(Gender);
        Utils.setText(driver, firstName, First_Name);
        Utils.setText(driver, lastName,Last_Name);
        Utils.selectFromDropDown(driver,dayOfBirth,Day_Of_Birth);
        Utils.selectFromDropDown(driver,monthOfBirth,Month_Of_Birth);
        Utils.selectFromDropDown(driver,yearOfBirth,Year_Of_Birth);
        Utils.setText(driver, Email, email);
        Utils.setText(driver, companyName, Company_Name);
        Utils.setText(driver, Password, password);
        Utils.setText(driver, confirmPassword, Confirm_Password);
        Utils.clickButton(driver, registerButton);
    }
}
