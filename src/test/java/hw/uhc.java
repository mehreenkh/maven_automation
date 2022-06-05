package hw;

import Reusable_Libaries.Reusable_Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class uhc {
    public static void main(String[] args) throws InterruptedException {
        // set local driver to reusable driver SetDriverMethod
        WebDriver driver = Reusable_Actions.setDriver();

        //declare first name
        ArrayList<String> firstName = new ArrayList<>();
        firstName.add("mehreen");
        firstName.add("kfgf");
        firstName.add("cvfd");

        //declare last name
        ArrayList<String> lastName = new ArrayList<>();
        lastName.add("kha");
        lastName.add("gif");
        lastName.add("que");

        //birthday
        ArrayList<String> birthDay = new ArrayList<>();
        birthDay.add("10");
        birthDay.add("11");
        birthDay.add("12");

        // birth year
        ArrayList<String> birthYear = new ArrayList<>();
        birthYear.add("1994");
        birthYear.add("1995");
        birthYear.add("1996");

        //zip code
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11417");
        zipCode.add("11420");
        zipCode.add("11208");

        // member ID
        ArrayList<String> memberID = new ArrayList<>();
        memberID.add("45466");
        memberID.add("48585");
        memberID.add("85486");


        // navigate to UHC.com
        driver.navigate().to("http://www.uhc.com");

        // verify homepage title contains
        Reusable_Actions.getTitle(driver, "//*[@class='lg-show']", "Health insurance plans");

        // click on "Find a doctor"
        Reusable_Actions.clickAction(driver, "//*[@aria-label='Find a doctor']", " Find a doctor");

        // click on Sign in
        Reusable_Actions.clickAction(driver, "//*[@class='mr-4']", "Sign in ");

        // click on Medicare plan
        Reusable_Actions.clickAction(driver, "//*[@data-index='1']", "Medicare plan");

        // open new tab
        Reusable_Actions.getwindow(driver, "window tab");

        // click on register now
        Reusable_Actions.clickAction(driver, "//*[@class='uhc-tempo-link uhc-tempo-link--medium registerBtn ng-scope']", "register now");

        // enter your first name
        for (int i = 0; i < firstName.size(); i++) {
            Reusable_Actions.sendKeysAction(driver, "//*[@id='firstName']", firstName.get(i), "first name");

            // enter your last name
            Reusable_Actions.sendKeysAction(driver, "//*[@id='lastName']",lastName.get(i), "last name");

            // select birth month
            Reusable_Actions.mouseHover(driver, "//*[@id='dob_month_input']", "birthmonth");
            Reusable_Actions.selectbytext(driver,"//*[@id='dob_month_input']","January","birthmonth");
            Reusable_Actions.sendKeysAction(driver, "//*[@id='dob_month_input']", "January", "birthmonth");

            // Enter bday

                Reusable_Actions.mouseHover(driver, "//*[@id='dob_day']", "bday");
                Reusable_Actions.sendKeysAction(driver, "//*[@id='dob_day']", birthDay.get(i), "bday");

                // Enter year
                Reusable_Actions.mouseHover(driver, "//*[@id='dob_year']", "year");
                Reusable_Actions.sendKeysAction(driver, "//*[@id='dob_year']", birthYear.get(i), "year");

                // enter zipcode

                Reusable_Actions.mouseHover(driver, "//*[@id='zipCode']", "Zipcode");
                Reusable_Actions.sendKeysAction(driver, "//*[@id='zipCode']", zipCode.get(i), "zipcode");

                // enter id
                Reusable_Actions.sendKeysAction(driver, "//*[@name='memberId']", memberID.get(i), "id");

                //click on continue button
                Reusable_Actions.clickAction(driver, "//*[text()='Continue']", "register now");

                // capture text error
                Reusable_Actions.selectbytext(driver, "//*[@id='plainText_error']", " We're having trouble finding you in our records. Please check that your entries match the information on your health insurance ID card. ", "text");
                System.out.println(" We're having trouble finding you in our records. Please check that your entries match the information on your health insurance ID card. ");


        }
        }
        } // end of main






