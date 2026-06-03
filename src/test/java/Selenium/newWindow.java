package Selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class newWindow {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "C://Users//yusuf//OneDrive//Documents//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        //Switching to New Window or new TAB
        driver.switchTo().newWindow(WindowType.TAB);
        //getting window IDs wit set method as default
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        String parentWindowId = it.next();
        String childWindowId = it.next();
        driver.switchTo().window(childWindowId);
        driver.get("https://rahulshettyacademy.com/");
        String courseName = driver.findElement(By.xpath("//h1[@class='text-3xl md:text-4xl lg:text-5xl xl:text-6xl font-bold leading-tight']")).getText();
        System.out.println(courseName);
        driver.switchTo().window(parentWindowId);
        WebElement name = driver.findElement(By.xpath("//input[@name=\"name\"][1]"));
        name.sendKeys(courseName);
        //Take screenShot of webElement
        File file = name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("name.png"));
        Thread.sleep(1000);
        //Get Height and Width of edit box
        System.out.println(name.getRect().getDimension().getHeight());
        System.out.println(name.getRect().getDimension().getWidth());
        //driver.quit();

    }
}
