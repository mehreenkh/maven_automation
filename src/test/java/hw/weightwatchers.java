package hw;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class weightwatchers {
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

        ArrayList<String> zcode = new ArrayList<>();
        zcode.add("11416");
        zcode.add("10022");
        zcode.add("11415");

        for (int i = 0; i < zcode.size(); i++) {

//navigate to website
            driver.navigate().to("https://www.weightwatchers.com/us/");
            Thread.sleep(1000);

            // go to attend
            try {
                driver.findElement(By.xpath("//*[@da-label='Attend']")).click();
                Thread.sleep(1000);
            } catch (Exception e) {
                // print out the exception
                System.out.println(" cant click attend");
            }
            try {
                // click on unlimited
                driver.findElement(By.xpath("//*[@data-e2e-name='unlimited_workshops']")).click();
            } catch (Exception e) {
                // print out exception
                System.out.println(" cant click on unlimited ");
            }
            try {
                //click on studio
                driver.findElements(By.xpath("//*[text() = 'Studio']")).get(0).click();
                Thread.sleep(3000);
            } catch (Exception e) {
                // print out exception
                System.out.println(" cant click studio");
            }


            // enter zipcodes
            try {
                driver.findElement(By.xpath("//*[@id='location-search']")).sendKeys(zcode.get(i));
                driver.findElement(By.xpath("//*[@id='location-search']")).submit();

            } catch (Exception e) {
                // print out exception
                System.out.println(" locate zipcode " + e);
            }
            // end of search

            // click on search arrow
            try {
                driver.findElement(By.xpath("//*[@id='location-search-cta']")).click();
                Thread.sleep(3000);
            } catch (Exception e) {
                // print out exception
                System.out.println(" search arrow " + e);

                // click on studio link
                try {
                    ArrayList<WebElement> searchResults = new ArrayList<>(driver.findElements(By.xpath("//*[@class = 'linkContainer-1NkqM']")));
                    if (i == 0) {
                        searchResults.get(1).click();
                    } else if (i == 1) {
                        searchResults.get(2).click();
                    } else if (i == 2) {
                        searchResults.get(0).click();
                    }
                } catch (Exception f) {
                    System.out.println("Unable to see list of studio locations" + f);
                    Thread.sleep(3000);
                }// exception end

// print studio address
                    try {
                        String studioAddress = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
                        Thread.sleep(1000);
                        System.out.println("The address for the studio is" + studioAddress);
                    } catch (Exception f) {
                        //print out the exception
                        System.out.println("Unable to print studio address" + f);

                        try {
                            JavascriptExecutor jse = (JavascriptExecutor) driver;
                            jse.executeScript("scroll 0,400");

                        }catch(Exception e1) {
                            //printing exception
                            System.out.println("Unable to scroll " + e);
                        }//end of exception

                        //print studio schedule

                        try {
                            String studioSchedule = driver.findElement(By.xpath("//*[@class = 'scheduleContainerMobile-1RfmF']")).getText();
                            System.out.println("The schedule of the studio " + studioSchedule);
                        }catch (Exception e1){
                            System.out.println("The schedule to the studio " + e);

                        }//end of exception

                } // end of search

            }    // end of loop
        } // end of main

    } // end of class

}
