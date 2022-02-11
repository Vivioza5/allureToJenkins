package my.company.Pages.factory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


import static io.github.bonigarcia.wdm.config.DriverManagerType.FIREFOX;

public class FirefoxDriverManager implements IBrowserFactory {
    public WebDriver createDriver(FirefoxOptions firefoxOptions) {
        WebDriverManager.getInstance(FIREFOX).setup();
        return new FirefoxDriver(firefoxOptions);
    }
}
