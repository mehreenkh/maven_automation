package ReusableClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Reusable_Actions {
    //resuable function for webdriver as a return method
    public static WebDriver setDriver() {
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver
        options.addArguments("start-maximized");
        //for mac use full screen
        //options.addArguments("start-fullscreen");
        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }//end of setDriver method

    //create a mouse hover method
    public static void mouseHover(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("Unable to hover on element " + elementName + " " + e);
        }
    }//end of mouseHover

    //create a click method
    public static void clickAction(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
        }
    }//end of clickAction

    //create a sendkeys method
    public static void sendKeysAction(WebDriver driver, String xpath, String userValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.sendKeys(userValue);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
        }
    }//end of sendkeys method

    //create a getText method
    public static String getTextAction(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String result = null;
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            result = element.getText();
        } catch (Exception e) {
            System.out.println("Unable to capture text on element " + elementName + " " + e);
        }
        return result;
    }//end of getTextAction method

    //create a click by index method
    public static void clickByIndexAction(WebDriver driver, String xpath, int indexNumber, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
        }
    }//end of clickByIndexAction


    // switch to tab index
    public static void getwindow(WebDriver driver, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
        } catch (Exception e) {
            System.out.println("Unable to new window " + elementName + " " + e);
        }
    }// switch to tab index

    public static String getTitle(WebDriver driver, String xpath, String elementname) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String getTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).getText();
        if (getTitle.equals("Health Insurance plans")) {
            System.out.println("My title matches");
        } else {
            System.out.println("Title doesn't match. Actual title is" + getTitle);
        } //
        return getTitle;
    } // end of title


    // select by text

    public static void selectbytext(WebDriver driver,String xpath, String textValue,String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
         Select actions = new Select(element);
         actions.selectByVisibleText(textValue);
        } catch (Exception e) {
            System.out.println("Unable to select tect " + elementName + " " + e);
        }
    }//end of select

    public static String verifyTitle(WebDriver driver,String xpath,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        String actualTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).getText();
        if (actualTitle.equals("Health Insurance plans")) {
            System.out.println("My title matches");
        }else {
            System.out.println("Title doesn't match. Actual Title is " + actualTitle);
        }
        return actualTitle;
    }//end of verify title method

    //create a submit method
    public static void submitAction(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.submit();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
        }
    }//end of submitAction

    public static String verifyTitle(WebDriver driver, String expectedTitle){
        WebDriverWait wait = new WebDriverWait(driver,10);
        String verifyTitle = driver.getTitle();
        if (verifyTitle.contains(expectedTitle)){
            System.out.println("My title matches");
        } else {
            System.out.println("Title doesn't match. Actual title is " + verifyTitle);
        }
        return verifyTitle;
    }//end of switch to tab by index







}













