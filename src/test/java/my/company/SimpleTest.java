package my.company;

import my.company.Pages.Chrome;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class SimpleTest {
WebDriver driver;

    @BeforeTest
    public void setUp() throws IOException {
        driver = Chrome.getInstanceOfChrome();
    }


    @Test
    public void simpleTestOne() {
String login_url = "https://opensource-demo.orangehrmlive.com/";
        driver.get(login_url);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        System.out.println(driver.getTitle());
    }
    @Test
    public void simpleTestTwo() {
        step("step 1");
        step("step 2");
    }
        @AfterTest
    public void tearDown() {
        driver.quit();
    }

}

