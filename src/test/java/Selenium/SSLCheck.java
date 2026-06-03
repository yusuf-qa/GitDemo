package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        //Proxy proxy = new Proxy();
       // proxy.setHttpProxy("ipaddress:4444");
        //options.setCapability("proxy", proxy);
        options.setAcceptInsecureCerts(true);
        System.setProperty("webdriver.chrome.driver", "C://Users//yusuf//OneDrive//Documents//chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());
        //chromedriver.chromium.org/capabilities
    }
}
