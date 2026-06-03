package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class BaseAddToCart {
    public static void main(String[] args) throws InterruptedException {
        //Wait Implicit wait and Explicit wait
        //**run this scenario in debug mode to learn debugging idea
        //Scenario: Add multiple products to add to cart
        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot", "Cauliflower"};
        System.setProperty("webdriver.chrome.driver", "C://Users//yusuf//OneDrive//Documents//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //******implementing global wait i.e implicit wait******
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //**explicit wait test commented implicite wait!
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        Thread.sleep(3000);
        //imp as code removed and moved to below method to look good.
        addItems(driver, itemsNeeded);
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]")).click();
        //checkpoint for verification of implicitly wait
        //explicit wait implemented
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();
        //******explicit wait*****
        //WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoinfo")));
        System.out.println(driver.findElement(By.cssSelector("span.promoinfo")).getText());


    }

    public static void addItems(WebDriver driver, String[] itemsNeeded) {

        //List<WebElement> itemsToAdd=driver.findElements(By.xpath("//button[text()='ADD TO CART']"));
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        int j = 0;
        for (int i = 0; i < products.size(); i++) {
            //Brocolli - 1 Kg
            //Brocolli , 1 kg

            String[] name = products.get(i).getText().split("-");
            //name[0]= Brocolli (with space)
            String formattedName = name[0].trim();
            //check name extracted is present in array or not
            //convert array into arrayList for easy search
            //format the text to actual vegetable name
            List itemsNeededList = Arrays.asList(itemsNeeded);


            if (itemsNeededList.contains(formattedName)) {
                j++;
                //click add to cart
                //Add to cart text is changing for seconds because of that index will change and it added tomato
                //div[@class='product-action']
                //driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                //we cannot use break point in when it is array some java logic need to apply
                if (j == itemsNeeded.length) {
                    break;
                }

            }

        }
    }
}
