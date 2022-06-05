package day7_051522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class selectMortgacecalc {
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

        //navigate to mortagage calc
        driver.navigate().to("https://www.mortgagecalculator.org");
        Thread.sleep(3000);
                // select start month from the dropdown
        WebElement startMonth = driver.findElement(By.xpath("//*[@name='param[start_month]']"));
        //define select command
        //Select dropDown = new Select(startMonth);
        // select by visible text
        //dropDown.selectByVisibleText("Jun");
        // select Loan Type from dropdown
        WebElement loanType = driver.findElement(By.xpath("//*[@name='param[milserve]']"));
        //define select command
        Select loanTypeDropdown = new Select(loanType);
        // select by visible text
        loanTypeDropdown.selectByVisibleText("FHA");
        // select Loan Type from dropdown

        // click on dropdown and its value if the dropdown tag is not under select tag
        startMonth.click();
        // click on the value of the start Month
        driver.findElement(By.xpath("//*[text()='Jun']")).click();


    } // end of main
} // end of class
