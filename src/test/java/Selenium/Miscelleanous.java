package Selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Miscelleanous {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "C://Users//yusuf//OneDrive//Documents//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //driver.manage().deleteCookieNamed("sessionkey");
        driver.get("https://google.com/");
        //casting driver object to TakesScreenshot object
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //FileUtils is java function need library of commons-io
        FileUtils.copyFile(src,new File("C:\\Users\\yusuf\\OneDrive\\Desktop\\screenshot.png"));

    }
}