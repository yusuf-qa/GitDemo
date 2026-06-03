package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locator3 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C://Users//yusuf//OneDrive//Documents//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //implicitewait i.e global
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.findElement(By.xpath("//div/button[1]/following-sibling::button[1]")).getText());
        //parent to child and sibling to sibling transverse //div/button[1]/following-sibling::button[1]
        System.out.println(driver.findElement(By.xpath("//div/button[1]/parent::div/button[2]")).getText());
        //child to parent


    }
}
