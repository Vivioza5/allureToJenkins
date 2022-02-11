package my.company.Pages.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;

public class ChromeDriverManager implements IBrowserFactory {
     public WebDriver createDriver(ChromeOptions options) {
        WebDriverManager.getInstance(CHROME).setup();
        return new ChromeDriver(options);
    }
}
