package tests;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pages.Utils;

public class TestBase {


    protected WebDriver driver;
    String url = "https://demo.nopcommerce.com/";

    @BeforeTest(description = "Open the browser") //open the browser
    public void openBrowser()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Utils.navigateToUrl(driver,url);
    }

   @AfterTest (description = "close the browser") //close the browser
    public void closeBrowser()
    {
        driver.quit();
    }


}
