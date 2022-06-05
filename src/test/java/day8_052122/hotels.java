package day8_052122;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class hotels {
    public static void main(String[] args) throws InterruptedException {
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

        ArrayList<String> cities = new ArrayList<>();
        cities.add("Los Angeles");
        cities.add("Miami");
        cities.add("Chicago");

        ArrayList<String> checkin = new ArrayList<>();
        checkin.add("Jun 1 2022");
        checkin.add("Jun 9 2022");
        checkin.add("Jun 17 2022");

        ArrayList<String> checkout = new ArrayList<>();
        checkout.add("Jun 8 2022");
        checkout.add("Jun 14 2022");
        checkout.add("Jun 22 2022");

        ArrayList<String> travelnum = new ArrayList<>();
        travelnum.add("2");
        travelnum.add("4");
        travelnum.add("6");


        driver.navigate().to("https://www.hotels.com");
        Thread.sleep(1000);
        try {
            WebElement goingto = driver.findElement(By.xpath("//*[@aria-label='Going to']"));
            goingto.click();
            Thread.sleep(1000);

            WebElement searchInput = driver.findElement(By.xpath("//*[@id='location-field-destination']"));
            searchInput.clear();
            searchInput.sendKeys("Los Angeles");
        } catch (Exception error){
            System.out.println(" Unable to locate search Bar" + error);
        } // end of "Unable to locate search Bar " exception

        // enter in check in date
        try{
            WebElement checkIn = driver.findElement(By.xpath("//*[@aria-label='Check-in June 1,2022']"));
            checkIn.click();
            Thread.sleep(1000);
        } catch (Exception error){
            System.out.println("Unable to enter check in date" + error);
        } // end of check in date

        // enter in check out date
        try{
            WebElement checkOut = driver.findElement(By.xpath("//*[@aria-label='Check-in June 8,2022']"));
            checkOut.click();
            Thread.sleep(1000);
        } catch (Exception error){
            System.out.println("Unable to enter check out date" + error);
        } // end of check out date

    } // end of main

} // end of class
