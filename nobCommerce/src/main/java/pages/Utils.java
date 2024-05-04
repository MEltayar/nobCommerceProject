package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.io.FileReader;
import java.io.FileNotFoundException;
import io.restassured.path.json.JsonPath;



public class Utils extends PageBase {

    public Utils(WebDriver driver) {
        super(driver);
    }

    static Select select;


    //Method to click on button
    protected static void clickButton(WebDriver driver, By buttonLocator) {
        driver.findElement(buttonLocator).click();
    }

    //Method to set text
    protected static void setText(WebDriver driver, By buttonLocator, String value) {
        driver.findElement(buttonLocator).sendKeys(value);
    }

    //Method to select from drop down menu
    protected static void selectFromDropDown(WebDriver driver, By dropDownElement, String text) {
        select = new Select(driver.findElement(dropDownElement));
        select.selectByVisibleText(text);
    }

    //Method to navigate to url
    public static void navigateToUrl(WebDriver driver, String url) {

        driver.get(url);
    }

    public static class JsonFileManager {

        private final String jsonFilePath;
        private FileReader reader;

        public JsonFileManager(String jsonFilePath) {
            this.jsonFilePath = jsonFilePath;
            try {
                reader = new FileReader(jsonFilePath);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        /**
         * @param jsonPath json Path
         * @return test data value from JSON file
         */
        public String getTestData(String jsonPath) {
            Object testData;
            try {
                reader = new FileReader(jsonFilePath);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            testData = JsonPath.from(reader).getString(jsonPath);
            return String.valueOf(testData);
        }
    }
}