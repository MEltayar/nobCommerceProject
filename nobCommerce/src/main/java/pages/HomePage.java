package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage extends PageBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public By regButton =  By.xpath("//a[@class='ico-register']");
    public By loginButton =  By.xpath("//a[@class='ico-login']");

    public void clickRegButton(){
        Utils.clickButton(driver, regButton);

    }
    public void clickLoginButton(){
        Utils.clickButton(driver, loginButton);

    }

}