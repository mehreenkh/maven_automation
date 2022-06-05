package day5_050822;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class ForLoop_ArrayList_GoogleSearch {
    public static void main(String[] args) throws InterruptedException {
    //capture such number and print for following cities using arrayList for Loop
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
        driver.navigate().to("http://www.google.com");
        //maximize the driver

        ArrayList<String> cities = new ArrayList<>();
        cities.add("Brooklyn");
        cities.add("Queens");
        cities.add("Bronx");
        for(int i=0; i < cities.size(); i++) {
            // go to Google home page
            driver.navigate().to("http://www.google.com");
            //maximize the driver
            driver.manage().window().maximize();
            // locate element for search field and type keyword 'cars'

            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(cities.get(0));
            Thread.sleep(3000);
            //submit on google search button
            driver.findElement(By.xpath("//*[@name='q']")).submit();
            //capture the google search and print it
            String searchResult = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
            //System.out.println("Result is " + searchResult);
            //extract out the number and print the number only
            String[] arrayResult = searchResult.split(" ");
            System.out.println("My search number for city " + cities.get(i) + " is " + arrayResult[1]);
        } //end of for loop

            //quit the driver
            driver.quit();

    }// end of main
} // end of class
