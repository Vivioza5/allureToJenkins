package my.company.Pages.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import my.company.utils.ReadConfig;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;


public class BrowserFactory {
    private static final ChromeOptions chromeOptions = new ChromeOptions();
    private static final FirefoxOptions firefoxOptions = new FirefoxOptions();
    private static final int WIDTH = Integer.parseInt(ReadConfig.get("width"));
    private static final int HEIGHT = Integer.parseInt(ReadConfig.get("height"));

    private BrowserFactory() {

    }

    private static ChromeOptions setChromeOptions() {
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        chromeOptions.addArguments("--window-size=" + WIDTH + "," + HEIGHT);
        return chromeOptions;
    }

    private static FirefoxOptions setFirefoxOptions() {
        firefoxOptions.addArguments("--width=" + WIDTH + " ", "--height=" + HEIGHT + "");
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        return firefoxOptions;
    }

    public static WebDriver createInstance() {
        WebDriver instanceBrowser;
        switch (ReadConfig.get("browser")) {
            case "CHROME":
                instanceBrowser = new ChromeDriverManager().createDriver(setChromeOptions());
                break;
            case "FIREFOX":
                instanceBrowser = new FirefoxDriverManager().createDriver(setFirefoxOptions());
                break;
            case "REMOTECHROME":

                instanceBrowser = new RemoteDriver().createDriver();
                break;
            default:
                throw new RuntimeException(String.format("Unknown browser type: \"%s\"", ReadConfig.get("browser")));
        }
        return instanceBrowser;
    }
}
