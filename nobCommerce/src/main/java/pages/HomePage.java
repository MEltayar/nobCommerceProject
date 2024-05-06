package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage extends PageBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    String url = "https://demo.nopcommerce.com/";
    public By regButton =  By.xpath("//a[@class='ico-register']");
    public By loginButton =  By.xpath("//a[@class='ico-login']");

    @Step("Navigate to nopcommerce home page")
    public void navigateToHomePage(){
        Utils.navigateToUrl(driver, url);
    }

    @Step("Click the Register Button")
    public void clickRegButton(){
        Utils.clickButton(driver, regButton);

    }
    @Step("Click the Login Button")
    public void clickLoginButton(){
        Utils.clickButton(driver, loginButton);

    }

}