import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Locator2 {
    public static void main(String[] args) {

        //Locatord Class Methods
        Locatord locatord = new Locatord();
        WebDriver driver = locatord.configDriver();
        locatord.openWebsite(driver);
        locatord.signInBYRegularExpression(driver);

        //Locator2 Class Method
        Locator2 locatord2 = new Locator2();
        locatord2.callAllMethods(locatord2, driver);
    }

    // Call All Methods In THis Class
    public void callAllMethods(Locator2 locator2, WebDriver driver) {
        locator2.findElementIfOnlyOneTag(driver);
        locator2.findElementUseAssertEqual(driver);
        locator2.logoutByOptionalElement(driver);
    }

    //====================If Only One Tag p on Page ====================================
    public void findElementIfOnlyOneTag(WebDriver driver) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(driver.findElement(By.tagName("p")).getText());
    }

    //==========================Assert Equals Use=====================================
    public void findElementUseAssertEqual(WebDriver driver) {

        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
    }

    //========================Logout with CUstomize XPATH ===================================
    public void logoutByOptionalElement(WebDriver driver) {
        driver.findElement(By.xpath("//*[text()='Log Out']")).click();
    }


}
