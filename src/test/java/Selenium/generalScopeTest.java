package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class generalScopeTest {
    public static void main(String[] args) throws InterruptedException {
        //imp open each link on footer 1st column and get the title of the page.
        //1. Give me the count of links on the page
        //2. Count of footer section
        System.setProperty("webdriver.chrome.driver", "C://Users//yusuf//OneDrive//Documents//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.findElements(By.tagName("a")).size());
        //find links only from the header,limiting webdriver scope
        WebElement driverFooter = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
        System.out.println(driverFooter.findElements(By.tagName("a")).size());
        //3. check number of links on footer first column
        WebElement columnDriver = driverFooter.findElement(By.xpath("//table/tbody/tr/td/ul[1]"));
        System.out.println(columnDriver.findElements(By.tagName("a")).size());

        //4. click on te each link in th e column and check if the pages are openings
        for (int i = 1; i < columnDriver.findElements(By.tagName("a")).size(); i++) {
            String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
            Thread.sleep(5000);
        }
        Set<String> abc = driver.getWindowHandles();
        Iterator<String> it = abc.iterator();
        while (it.hasNext()) {
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }


    }
}
