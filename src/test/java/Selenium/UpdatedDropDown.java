package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropDown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C://Users//yusuf//OneDrive//Documents//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //checkboxes
        //System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        //System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        //NUMBER OF CHECK BOXES ON THE PAGE
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

        //Selecting radio button and checking Calender dates filed is enabled or not
        //System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
        System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));
        if (driver.findElement(By.id("Div1")).getDomAttribute("style").contains("0.5"))
        {
            System.out.println("its enabled");
            Assert.assertTrue(true);
        }
        else
            {
            Assert.assertFalse(false);
        }

        //dropdown with select tag
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        //System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "1 Adult");
        for (int i = 1; i < 5; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        //System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
        driver.quit();

    }
}
