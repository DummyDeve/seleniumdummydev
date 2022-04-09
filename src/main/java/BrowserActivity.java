import Util.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserActivity {
    public static void main(String[] args) {
        WebDriver driver = BrowserActivity.configDriver();
        driver.manage().window().maximize();
        driver.get(Constants.WEB_URL_LOCATOR3_AutomationPractice_CLASS);
        driver.navigate().to(Constants.WEB_URL_SELEDEMO_CLASS);
        driver.navigate().back();
        driver.navigate().forward();
    }

    public static WebDriver configDriver() {
        System.setProperty("webdriver.chrome.driver", "/home//Selenium/Drivers/chromedriver");
        WebDriver driver = new ChromeDriver(); // gecko driver for firefox
        return driver;
        ///========= FireFox Browser =========
//        WebDriver driver = new FirefoxDriver();

        //====== Microsoft driver
        // edge drive
    }

}
