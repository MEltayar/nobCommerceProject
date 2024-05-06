package tests;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.Utils;

public class TestBase {
    protected WebDriver driver;
    @BeforeMethod(description = "Open the browser and navigate to the URL") //open the browser
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterMethod(description = "close the browser") //close the browser
    public void closeBrowser() {
        driver.quit();
    }
}
