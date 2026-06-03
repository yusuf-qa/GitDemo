package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C://Users//yusuf//OneDrive//Documents//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable/");
        //System.out.println(driver.findElements(By.tagName("iframe")).size());
        //frames can be serched by ID,index and locator
        //driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
        driver.switchTo().frame(0);
        //driver.findElement(By.cssSelector("div#draggable")).click();
        Actions a = new Actions(driver);
        WebElement source = driver.findElement(By.cssSelector("div#draggable"));
        WebElement target = driver.findElement(By.cssSelector("div.ui-widget-header.ui-droppable"));
        a.dragAndDrop(source,target).build().perform();
        driver.switchTo().defaultContent();

    }
}
