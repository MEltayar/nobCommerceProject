package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisteredSuccessfullyPage extends PageBase{

    public RegisteredSuccessfullyPage(WebDriver driver) {
        super(driver);
    }
     WebElement RegisterSuccessfullyMessage = driver.findElement(By.xpath("//div[@class='result']"));
    public String actualRegisterSuccessfullyMessage = RegisterSuccessfullyMessage.getText();
    public String expectedRegisterSuccessfullyMessage = "Your registration completed";


}
