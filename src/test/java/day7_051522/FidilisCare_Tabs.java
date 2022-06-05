package day7_051522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class FidilisCare_Tabs {
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
//navigate to fidelis care
        driver.navigate().to("https://www.fideliscare.org");
        Thread.sleep(1000);

        //click on shop for a plan
        //we are clicking on index B because there are two elements for this xpath
        driver.findElements(By.xpath("//*[text() = 'Shop For a Plan']")).get(0).click();
        // wait a bit for page to load
        Thread.sleep(1000);

        // click on Medicaid Managed Care
        driver.findElements(By.xpath("//*[text() = 'Medicaid Managed Care']")).get(0).click();
        // wait a bit for page to load
        Thread.sleep(1000);

        // click on search find a doctor card
        driver.findElement(By.xpath("//*[@href = '/findadoctor']")).click();
        // wait a bit for page to load
        Thread.sleep(1000);

        //store new tabs in an array List, we use getWindowHandles method to get list of tabs
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        // switch to new tab, it should be index 1
        driver.switchTo().window(tabs.get(1));
        //click on new search button
        driver.findElement(By.xpath("//*[@class = 'fal fa-search-plus']")).click();
        //wait a bit for the click
        Thread.sleep(1000);
        // close the new tab
        driver.close();
        //switch back to defualt tab
        driver.switchTo().window(tabs.get(0));
        // then click providers card
        driver.findElement(By.xpath("//*[@class ='fal fa-stethoscope fa-fw']")).click();
        // wait until provider card is click on
        Thread.sleep(3000);




    } // end of main
} // end of class
