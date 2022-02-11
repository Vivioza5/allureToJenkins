package my.company.Pages.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;

public class RemoteDriver {

         public WebDriver createDriver() {
              WebDriverManager.chromedriver().remoteAddress("http://localhost:4444/wd/hub").create();

             return new ChromeDriver();
         }
}
