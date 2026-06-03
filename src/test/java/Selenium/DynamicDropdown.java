package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C://Users//yusuf//OneDrive//Documents//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(2000);
        //imp to write xpath with index here
        //driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
        //below xpath without having index as used in above parent child relation
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

        //Selecting Calender dates
        //active date classname: ui-state-default ui-state-active  replace space with dot for css selector
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();

    }
}
