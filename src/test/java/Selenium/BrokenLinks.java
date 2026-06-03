package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args) throws URISyntaxException, IOException {


        System.setProperty("webdriver.chrome.driver", "C://Users//yusuf//OneDrive//Documents//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Broken URL
        //Step-1: get all the URLs tied to the links using Selenium
        //Step-2: Java methods will call URLs and get you the status code
        //Step0-3: if status code >400 then that url is not working --> link which tied to URL is broken
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");

        //test ng assert for soft assert it is used as hard assert will stop execution once it is failed i.e broken link
        // to test all the links below soft assert is used.
        SoftAssert a = new SoftAssert();

        List<WebElement> links = driver.findElements(By.cssSelector("li.gf-li a"));
        for(WebElement link:links){

            String url=link.getAttribute("href");
            HttpURLConnection conn = (HttpURLConnection)new URI(url).toURL().openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int resCode = conn.getResponseCode();
            System.out.println(resCode);
            a.assertTrue(resCode<400, "the link with text"+link.getText()+"is broken with code" +resCode);
        }

            a.assertAll();

    }
}
