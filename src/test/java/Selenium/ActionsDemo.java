package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C://Users//yusuf//OneDrive//Documents//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        Thread .sleep(3000);
        Actions a = new Actions(driver);
        //move mouse to web element
        WebElement move = driver.findElement(By.xpath("//div[@id='nav-link-accountList']"));
        a.moveToElement(move).contextClick().build().perform();
        //Composite action, click on edit box and type hello in capital letters
        Thread.sleep(1000);
        a.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT)
                .sendKeys("Hello").doubleClick().build().perform();
    }
}
