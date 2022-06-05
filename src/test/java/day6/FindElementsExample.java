package day6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FindElementsExample {
    public static void main(String[] args) throws InterruptedException {
        //go to bing, click on second element of links by using class and index
        // setup your chrome with webdrivermanager

        WebDriverManager.chromedriver().setup();
        // define the webdriver I am going to use
        // WebDriver driver = new ChromeDriver();
        //set the condition to inncongito mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incongito");
        //set the conditions to maximize/fullscreen your driver
        options.addArguments("start-maximized");
        //setting your driver headless (running on background)
        //options.addArguments("start-fullscreen");
        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);
        // go to Google home page

        //naviagte to bing home
        driver.navigate().to("http://www.bing.com");
        //maximize the driver
        Thread.sleep(3000);
        // click on Images using class property with index 1
        // to ignore white space in property value we can use comtinue to xpath
        driver.findElements(By.xpath("//li[contains(@class,'scope')]")).get(0).click();

    } // end of main
} // end of class
