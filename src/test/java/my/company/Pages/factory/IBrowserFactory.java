package my.company.Pages.factory;

import org.openqa.selenium.WebDriver;

public interface IBrowserFactory {
    public interface Factory {
    WebDriver createDriver();}
}
