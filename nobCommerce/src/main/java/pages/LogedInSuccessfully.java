package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogedInSuccessfully extends  PageBase{
    public LogedInSuccessfully(WebDriver driver) {
        super(driver);
    }

    WebElement logOut = driver.findElement(By.xpath("//a[@class='ico-logout']"));
    public String expectedLoginSuccessfully = logOut.getText();
}
