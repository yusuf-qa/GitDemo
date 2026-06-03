package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class E2E {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C://Users//yusuf//OneDrive//Documents//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@value='DEL']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();

        if (driver.findElement(By.id("Div1")).getDomAttribute("style").contains("0.5"))
        {
            System.out.println("its disabled");
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertTrue(false);
        }

        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "1 Adult");
        for (int i = 1; i < 5; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");

        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
        //driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();
        //driver.findElement(By.cssSelector("input[type='submit']")).click();
        //driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.quit();


    }
}
