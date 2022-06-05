package day11_052922;

import Reusable_Libaries.Reusable_Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class uspslis_webelementexample {
    //set webdriver/declare outside so it is global and is resubale with other annotation methods
    WebDriver driver;

    //before suite will set the driver you are using
    @BeforeSuite
    public void SetChromeDriver(){
        driver = Reusable_Actions.setDriver();
    }//end of before suite annotation

    @Test()
    public void USPS_Tabs_Count() throws InterruptedException {
        //navigate to usps
        driver.navigate().to("https://www.usps.com");
        //declare explicit wait for the tabs
        WebDriverWait wait = new WebDriverWait(driver,10);
        //store the navigation tabs as a list to get the count
        List<WebElement> tabsCount = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[contains(@class,'menuheader')]")));
        //print the tab count
        System.out.println("Tabs count is " + tabsCount.size());

        for(int i = 0; i < ((List<?>) tabsCount).size(); i++){
            driver.navigate().to("https://www.usps.com");
            tabsCount = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[contains(@class,'menuheader')]")));
            //click on each tab
            tabsCount.get(i).click();
        }
    }//end of test




    @AfterSuite
    public void quitSession(){
        driver.quit();
    }// end of after suit

}
