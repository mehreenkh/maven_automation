package day6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class scroll_mortageclass {
    public static void main(String[] args) throws InterruptedException {
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


        //naviagate to mortagecalculator site
        driver.navigate().to("https://www.mortgagecalculator.org");
        Thread.sleep(3000);
        //declare  javascript variable
        JavascriptExecutor jse = (JavascriptExecutor) driver;
                //scroll to pixel 400 on mortage calc website
        // jse.executeScript("scroll(0,800)");
        //wait a bit for browser to preform scrolling
        // Thread.sleep(3000);
        //declare a webelement variable that we want to scroll into
        WebElement shareButton = driver.findElement(By.xpath("//*[@id='share_button']"));
        //scroll into share this calculation button
        jse.executeScript("arguments[0].scrollIntoView(true);",shareButton);
        Thread.sleep(3000);
        //click on the share this calculation button
        shareButton.click();
        Thread.sleep(3000);
        //scroll back up
        jse.executeScript("scroll(0,-400)");
        // quit the driver
        driver.quit();
    } // end of main

} // end of class
