package day6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebLemlent_mortagaecalc {

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

        //click,clear and enter new value on home value feild
        WebElement homeValue = driver.findElement(By.xpath("//*@id='homeval']"));
        homeValue.click();
        homeValue.clear();
        homeValue.sendKeys("45000");

        // click on % radio button
        driver.findElement(By.xpath("//*@value='percent']")).click();

        // click, clear and enter new data on down payment feild
        WebElement downPayment = driver.findElement(By.xpath("//*[@id='downpayment']"));
        downPayment.click();
        downPayment.clear();
        downPayment.sendKeys("5");

    } // end of java
} // end of class
