package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By Email = By.id("Email");
    By Password = By.id("Password");
    By loginButton = By.xpath("//button[@class='button-1 login-button']");

    @Step("Enter the login credentials")
    public void  loginCredentials(String email, String password){
        Utils.setText(driver,Email,email);
        Utils.setText(driver,Password,password);
        Utils.clickButton(driver,loginButton);
    }



}
