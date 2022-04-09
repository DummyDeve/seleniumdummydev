import Util.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locatord {
    public static void main(String[] args) {

        Locatord locatord = new Locatord();
        WebDriver driver = locatord.configDriver();
        locatord.callBasicMethods(locatord,driver);
        locatord.callRegularExpressionMethods(locatord,driver);
        //locatord.closeWebBrowser(locatord,driver);
    }

    public void signInBYRegularExpression(WebDriver driver){
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys(Constants.WEB_URL_LOCATOR_CLASS_DUMMY_USER);
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(Constants.WEB_URL_LOCATOR_CLASS_DUMMY_PASSWORD);
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
    }

    // ==========================Close Web Browser=========================
    public void closeWebBrowser(Locatord locatord,WebDriver driver){
        locatord.closeDriver(driver);
    }

    //========================Call All Methods at One============================
    public void callBasicMethods(Locatord locatord,WebDriver driver){
        locatord.openWebsite(driver);
        locatord.findelementById(driver);
        locatord.findElementByName(driver);
        locatord.findElementByCLassName(driver);
        locatord.findElementByCssSelector(driver);
        locatord.findElementByLinkText(driver);
        locatord.findElementByXPATH(driver);
        locatord.findElementByCssSelectorTwo(driver);
        locatord.findElementByXPATHTwo(driver);
        locatord.findElementByCssSelectorThree(driver);
        locatord.findElementByXPATHThree(driver);
        locatord.findElementByCssSelectorFour(driver);
        locatord.findElementByCssSelectorFive(driver);
    }

    // Regular Expression Call
    public void callRegularExpressionMethods(Locatord locatord,WebDriver driver){
        locatord.signInBYResetButtonRegularExpression(driver);
    }

    //======================Config Driver==============================
    public WebDriver configDriver(){
        System.setProperty("webdriver.chrome.driver","/home//Selenium/Drivers/chromedriver");
        WebDriver driver = new ChromeDriver(); // gecko driver for firefox
        return driver;
        ///========= FireFox Browser =========
//        System.setProperty("webdriver.gecko.driver","/home//Selenium/Drivers/geckodriver");
//        WebDriver driver = new FirefoxDriver();

        //====== Microsoft driver
        // edge drive
    }

    //=====================Get the URL====================================
    public void openWebsite(WebDriver driver){
        driver.get(Constants.WEB_URL_LOCATOR_CLASS);
    }

    //===================Locators=======================

    //=========================FindElement By ID=================================
    public void findelementById(WebDriver driver){
        driver.findElement(By.id("inputUsername")).sendKeys("rahul");
    }

    // ==========================Find Element By Name==========================

    public void findElementByName(WebDriver driver){
        driver.findElement(By.name("inputPassword")).sendKeys("hello123");
    }

    //============================= Find Elemenet By Class Name======================
    public void findElementByCLassName(WebDriver driver){
        driver.findElement(By.className("signInBtn")).click();
    }


    // =======================Find Element By Link Text For anchor tag========================
    public void findElementByLinkText(WebDriver driver){
        driver.findElement(By.linkText("Forgot your password?")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //============================XPATH & CSS SELECTOR LOCATOR CUSTOMIZE ========================================

    // CSS - p.error By ClassName
    // Implicit Timeout Wait
    public void findElementByCssSelector(WebDriver driver){
        //Implici Wait - 2 sec timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // dynamic element get
        driver.findElement(By.cssSelector("p.error")).getText();
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
    }

    // CSS - input[placeholder='Email']
    public void findElementByCssSelectorTwo(WebDriver driver){
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys(Constants.DUMMY_EMAIL);
    }

    // CSS - nth-child(3)
    public void findElementByCssSelectorThree(WebDriver driver){
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys(Constants.DUMMY_EMAIL);
    }

    //CSS - by Uniqe Class in All Page
    public void findElementByCssSelectorFour(WebDriver driver){
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
    }
    // CSS - Parent - Child
    public void findElementByCssSelectorFive(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // dynamic element get
        driver.findElement(By.cssSelector("form p")).getText();
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());
    }

    // XPATH - By Placeholder
    // XPATH - //input[@placeholder='Name']
    public void findElementByXPATH(WebDriver driver){
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Nishant");
    }

    // XPATH - Clear Field & Add Value By Index path
    // XPATH - //input[@type='text'][2]
    public void findElementByXPATHTwo(WebDriver driver){
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
    }

    // XPATH - Parent-child
    // XPATH - //form/input[3]
    public void findElementByXPATHThree(WebDriver driver){
        driver.findElement(By.xpath("//form/input[3]")).sendKeys(Constants.DUMMY_MOBILE);
    }


    // Regular Exression on XPATH AND CSS SELECTOR
    public void signInBYResetButtonRegularExpression(WebDriver driver){
        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys(Constants.WEB_URL_LOCATOR_CLASS_DUMMY_USER);
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(Constants.WEB_URL_LOCATOR_CLASS_DUMMY_PASSWORD);
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
    }

    //============================END XPATH & CSS SELECTOR LOCATOR CUSTOMIZE ========================================



    //=======================EndLocator====================

    //Close & Quit Driver
    public void closeDriver(WebDriver driver){
        //CLose browser - tab close only
        driver.close();
        //Quit - close all associate window with it
        //driver.quit();
    }
}
