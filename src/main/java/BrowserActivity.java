import Util.Constants;
import org.openqa.selenium.WebDriver;

public class BrowserActivity {
    public static void main(String[] args) {
        WebDriver driver = Locatord.configDriver();
        driver.manage().window().maximize();
        driver.get(Constants.WEB_URL_LOCATOR3_AutomationPractice_CLASS);
        driver.navigate().to(Constants.WEB_URL_SELEDEMO_CLASS);
        driver.navigate().back();
        driver.navigate().forward();
    }


}
