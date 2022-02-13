package my.company.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class LoginPage {
//    WebDriver driver;
 private RemoteWebDriver driver;
    @BeforeTest
    public void setUp() throws IOException {
//        driver = Driver.getInstanceOfBrowser();

    }

    @Test
    public void login() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "98.0");
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        RemoteWebDriver driver = new RemoteWebDriver(
                URI.create("http://0.0.0.0:4444/wd/hub").toURL(),
                capabilities
        );

        String login_url = "https://opensource-demo.orangehrmlive.com/";
        driver.get(login_url);

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        System.out.println(driver.getTitle());
    }


//    @AfterTest
//    public void tearDown() {
//        driver.quit();
//    }
}
