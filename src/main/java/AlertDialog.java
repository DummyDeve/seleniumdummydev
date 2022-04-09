import Util.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AlertDialog {
    public static void main(String[] args) {
        WebDriver driver = AlertDialog.configDriver();
        driver.manage().window().maximize();
        driver.get(Constants.WEB_URL_LOCATOR3_AutomationPractice_CLASS);
        alertDialog(driver);

    }



    public static WebDriver configDriver(){
        System.setProperty("webdriver.chrome.driver","/home//Selenium/Drivers/chromedriver");
        WebDriver driver = new ChromeDriver(); // gecko driver for firefox
        return driver;
        ///========= FireFox Browser =========
//        WebDriver driver = new FirefoxDriver();

        //====== Microsoft driver
        // edge drive
    }

    public static void alertDialog(WebDriver driver){
        driver.findElement(By.id("name")).sendKeys(Constants.WEB_URL_LOCATOR_CLASS_DUMMY_USER);
        driver.findElement(By.cssSelector("[id='alertbtn']")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        driver.findElement(By.id("confirmbtn")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
    }

}
