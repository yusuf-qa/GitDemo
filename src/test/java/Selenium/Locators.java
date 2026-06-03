package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C://Users//yusuf//OneDrive//Documents//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //implicitewait i.e global
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("yusuf.1512@gmail.com");
        driver.findElement(By.name("inputPassword")).sendKeys("Password123");
        driver.findElement(By.className("signInBtn")).click();
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("test");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("invalidemail@gmail.com");
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("test@gmail.com");
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("test@gmail.com");
        //parent child xpath
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("+4915163595180");
        //css selector for name attribute tag name is optional
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        // css selector parent child with space need to be used
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());
        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("yusuf");
        driver.findElement(By.cssSelector("input[type*='pass'")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.cssSelector("button[type='submit']")).click();




    }
}
