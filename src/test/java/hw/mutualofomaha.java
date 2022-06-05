package hw;

import Reusable_Libaries.Reusable_Actions;
import Reusable_Libaries.Reusable_Actions_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class mutualofomaha {
    // declare local driver outside so it can be reusable with other annotation methods
    WebDriver driver;
    ExtentReports reports;
    ExtentTest logger;
    // before suite set driver
    @BeforeSuite
    public void SetChromeDriver(){
        driver = Reusable_Actions.setDriver();
        //define the path to the report
        reports = new ExtentReports("src/main/java/HTML_Report/moh.html",true);
    }//end of before suite annotation

    // navigate to mutual of omaha
    @Test(priority = 1)
    public void SearchForKeyword(){
        logger = reports.startTest("planning and advice");
        driver.navigate().to("https://www.mutualofomaha.com");
        //click on planning and advice
        Reusable_Actions_Loggers.clickAction(driver,"//*[@class='SiteNav-itemLinkText']",logger,"Planning and Advice");
        //click ready for retirement
        Reusable_Actions_Loggers.clickAction(driver,"//*[@href='/advice/be-ready-for-retirement']",logger,"retirement");
        //end the logger per test
        reports.endTest(logger);
    }//end of test 1

        @Test(priority = 2)
       public void verifytitle() {
            logger=reports.startTest("verify title");
            driver.navigate().to("https://www.mutualofomaha.com");
            //verify title of the page
            Reusable_Actions_Loggers.verifyTitle(driver,"//*[@class='SectionTitle-Text']",logger,"");
reports.endTest(logger);
        } // end of test 2

       /*
    dependsOnMethods is used when  following @Test is dependent on previous @Test method. If the first test fails,
    the dependent test will get skipped
     */
    @Test(priority = 3)
    public void calculations (){
        logger=reports.startTest("calculations");
        // i was having trouble click on the retirement tab and tried to change the elements
        driver.navigate().to("https://www.mutualofomaha.com/advice/be-ready-for-retirement");
        //end the logger per test
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //scroll to pixel 400 on mortage calc website
         jse.executeScript("scroll(0,400)");
         //click on calculations
        Reusable_Actions_Loggers.clickAction(driver,"//*[@class='Callout-link']",logger,"calculate");
        //calcuate years
        Reusable_Actions_Loggers.clickAction(driver,"//*[@id='401kRetirementIncome|0|2']",logger,"years");
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        //scroll to pixel 400 on mortage calc website
        jse2.executeScript("scroll(0,400)");
        //annual income
        Reusable_Actions_Loggers.clickAction(driver,"//*[@name='clientIncome']",logger,"income");
        Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@name='clientIncome']","100,000",logger,"100,000");
        // click on savings
        Reusable_Actions_Loggers.clickAction(driver,"//*[@id='401kRetirementIncome|2|2']",logger,"income");
        Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@id='401kRetirementIncome|2|2']","10000",logger,"1000");
        JavascriptExecutor jse3 = (JavascriptExecutor) driver;
        //scroll to pixel 400 on mortage calc website
        jse3.executeScript("scroll(0,400)");
        //submit
Reusable_Actions_Loggers.clickAction(driver,"//*[@class='button-container']",logger,"submit");

        reports.endTest(logger);
    } // end of test 3

    @Test(priority = 4)
    public void tacklemyfiances (){
        logger=reports.startTest("tacklemyfinances");
        driver.navigate().to("https://www.mutualofomaha.com/advice/tackle-my-finances");
        Reusable_Actions_Loggers.clickAction(driver,"//*[@class='Callout-link']",logger,"calc");
        //savings
        Reusable_Actions_Loggers.clickAction(driver,"//*[@name='savingsBalance']",logger,"calc");
        Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@name='savingsBalance']","10,000",logger,"savings");
        //withdraw decrease
        Reusable_Actions_Loggers.clickAction(driver,"//*[@name='monthlyWithdrawal']",logger,"withdraw");
        Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@name='monthlyWithdrawal']","100",logger,"withdraw");
        //withdraw increase
        Reusable_Actions_Loggers.clickAction(driver,"//*[@name='withdrawalIncreases']",logger,"withdraw");
        Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@name='withdrawalIncreases']","2",logger,"withdraw");
        //submit results
        Reusable_Actions_Loggers.clickAction(driver,"//*[@class='button-container']",logger,"submit");
        reports.endTest(logger);
    }

@Test(priority = 5)
    public void changestate () {
    logger = reports.startTest("changestate");
    driver.navigate().to("https://www.mutualofomaha.com");
    //click on change state
    Reusable_Actions_Loggers.clickAction(driver, "//*[@href='#location-lookup-get-zip-modal']", logger, "change state");
// click on zip
    ArrayList<String> zipCode = new ArrayList<>();
    zipCode.add("11416");
    zipCode.add("11417");
    zipCode.add("11218");
    for (int i = 0; i < zipCode.size(); i++) {

        Reusable_Actions_Loggers.clickAction(driver, "//*[@id='zip']", logger, "zip");
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@id='zip']", zipCode.get(i), logger, "zip");
        reports.endTest(logger);
    }
}
    @AfterSuite
        public void quitSession(){
            driver.quit();
            reports.flush();
        }//end of after suite
    }




