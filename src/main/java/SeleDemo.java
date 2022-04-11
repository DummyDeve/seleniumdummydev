import Util.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SeleDemo{
    public static void main(String[] args) {


        SeleDemo selenium = new SeleDemo();
        WebDriver driver = Locatord.configDriver();
        selenium.openWebsite(driver);
        selenium.showContentOnConsole(driver);
        selenium.closeDriver(driver);


    }

    //Get the URL
    public void openWebsite(WebDriver driver){
        driver.get(Constants.WEB_URL_SELEDEMO_CLASS);
    }
    // Show Title & URL
    public void showContentOnConsole(WebDriver driver){
        //Get Title Of Current Page & show on console
        System.out.println(driver.getTitle());
        // Get Current URL & Show on console
        System.out.println(driver.getCurrentUrl());
    }
    //Close & Quit Driver
    public void closeDriver(WebDriver driver){
        //CLose browser - tab close only
        driver.close();
        //Quit - close all associate window with it
        //driver.quit();
    }
}