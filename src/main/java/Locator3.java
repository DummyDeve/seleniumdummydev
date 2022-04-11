import Util.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locator3 {
    public static void main(String[] args) {
        WebDriver driver = Locatord.configDriver();
        driver.get(Constants.WEB_URL_LOCATOR3_AutomationPractice_CLASS);
        Locator3.followingSibling(driver);
    }

    //==================Sibling following & Parent to ====================
    public static void followingSibling(WebDriver driver){
        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[1]")).getText());

    }

}
