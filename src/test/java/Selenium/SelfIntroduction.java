package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelfIntroduction {
    public static void main(String[] args) {
        //System.out.println("Welcome to Selenium java world");
        System.setProperty("webdriver.chrome.driver", "C://Users//yusuf//OneDrive//Documents//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.close();
        driver.quit();

    }
}
