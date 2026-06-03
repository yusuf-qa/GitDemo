package JavaStreams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class LiveDemoSorting {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C://Users//yusuf//OneDrive//Documents//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        //Algorithm for checking List of veges matching with original with expected after sorting(sudo code)
        //click on the column
        driver.findElement(By.xpath("//tr/th[1]")).click();
        //capture all web elements into list
        List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));
        //capture text of all web elements into new (original) list
        List<String> originalList = elementList.stream().map(s -> s.getText()).collect(Collectors.toList());
        //sort the original list of step3 --> sorted list
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
        //compare original list vs sorted list
        Assert.assertEquals(originalList, sortedList);

        //scan the name column with getText -> Beans ->print price of rice
        //pagination concept comes in to picture when we select "Rice" insted of "Beans" and implement do while loop as below
        List<String> price;
        do {
            List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
            price = rows.stream().filter(s -> s.getText().contains("Rice"))
                    .map(s -> getPriceOdVeggi(s)).collect(Collectors.toList());
            price.forEach(a -> System.out.println(a));
            if (price.size() < 1) {
                driver.findElement(By.cssSelector("[aria-label=\"Next\"]")).click();
            }
        } while (price.size() < 1);

    }


    private static String getPriceOdVeggi(WebElement s) {
        String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return priceValue;
    }
}

