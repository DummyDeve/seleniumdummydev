import Util.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = Locatord.configDriver();
        driver.manage().window().maximize();
        driver.get(Constants.WEB_URL_FLIGHTBOOK_CLASS);
        staticDropdown(driver);
        updatedDropdown(driver);
        dynamicDropdown(driver);
        autoSuggestive(driver);
        calendarValidate(driver);
        clickSearchButton(driver);
    }


    //Click Search Button
    public static void clickSearchButton(WebDriver driver){
        driver.findElement(By.cssSelector("input[value='Search']")).click();
        // driver.findElement(By.xpath("//input[@value='Search']")).click();
        // driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
    }
    //Calendar Handling with Current Date & Validate
    public static void calendarValidate(WebDriver driver){
        // System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
        {
            System.out.println("its enabled");
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertTrue(false);
        }
    }
    // Auto Suggestive
    public static void autoSuggestive(WebDriver driver) throws InterruptedException {
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(3000);
        List<WebElement> options =driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for(WebElement option :options)
        {
            if(option.getText().equalsIgnoreCase("India"))
            {
                option.click();
                break;
            }
        }
    }
    //Dynamic DropDown -  Parent child relationship
    public static void dynamicDropdown(WebDriver driver) throws InterruptedException {
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(2000);
//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

    }
    //Updated Dropdown
    public static void updatedDropdown(WebDriver driver) throws InterruptedException {
       driver.findElement(By.id("divpaxinfo")).click();
       Thread.sleep(2000L);
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        for (int i = 1; i < 5; i++){
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
    }

    //Static Dropdown
    public static void staticDropdown(WebDriver driver){
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(3);
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("AED");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByValue("INR");
        System.out.println(dropdown.getFirstSelectedOption().getText());
    }
}
