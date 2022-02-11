package my.company.Pages;

import my.company.Pages.factory.BrowserFactory;
import org.openqa.selenium.WebDriver;



public class Driver {
    private static WebDriver instanceOfBrowser = null;

    public static WebDriver getInstanceOfBrowser() {
        if (instanceOfBrowser == null) {
            instanceOfBrowser = BrowserFactory.createInstance();
            instanceOfBrowser.manage().deleteAllCookies();
        }
        return instanceOfBrowser;
    }
}
