package day8_052122;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class title {
    public static void main(String[] args) {
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
        driver.navigate().to("https://www.google.com");
// capture the title of the page and compare it with expected title
        String actualTitle = driver.getTitle();
        if(actualTitle.equals("Google")) {
            System.out.println("My title matches");
        } else {
            System.out.println("Title doesnt match. Actual Title is "+ actualTitle);
        }

    } // end of main
} // end of class
