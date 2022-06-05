package hw;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class googlesearch2 {
    public static void main(String[] args) throws InterruptedException {
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

        // go to bing and enter search feild
        ArrayList<String> hobbies = new ArrayList<>();
        hobbies.add("travel");
        hobbies.add("jogging");
        hobbies.add("shopping");

        for(int i=0; i< hobbies.size(); i++) {
            // go to bing home page

            driver.navigate().to("http://bing.com");
            Thread.sleep(3000);
            //maximize the driver
            driver.manage().window().maximize();
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(hobbies.get(i));
            // search

            driver.findElement(By.xpath("//*[@for='sb_form_go']")).submit();
            Thread.sleep(2000);
            String searchResult = driver.findElement(By.xpath("//*[@class ='sb_count']")).getText();
            //System.out.println("Result is " + searchResult);

            String[] arrayResult = searchResult.split(" ");
            System.out.println("Results for " + hobbies.get(i) + "is" + arrayResult[0]);


        }// end of loop

driver.quit();


    } // end of main
} // end of class
