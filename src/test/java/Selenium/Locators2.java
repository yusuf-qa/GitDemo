package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Locators2 {
    public static void main(String[] args) throws InterruptedException {
        String name = "Yusuf";
        System.setProperty("webdriver.chrome.driver", "C://Users//yusuf//OneDrive//Documents//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //implicitewait i.e global
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String password = getPassword(driver);
       // driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("inputUsername")).sendKeys("Yusuf");
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        Thread.sleep(1000);
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.tagName("p")).getText());
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
        System.out.println(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText());
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello " + name + ",");
        driver.findElement(By.xpath("//button[text()='Log Out']")).click();
        Thread.sleep(1000);
        driver.close();
    }

    public static String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        String passwordstr1 = driver.findElement(By.cssSelector("form p")).getText();
        //Please use temporary password 'rahulshettyacademy' to Login.
        String[] passwordstr2 = passwordstr1.split("'");
        //[0]= Please use temporary password '
        //[1]= rahulshettyacademy' to Login.
        String[] passwordstr3 = passwordstr2[1].split("'");
        String password4 = passwordstr3[0];
        return password4;

    }
}
