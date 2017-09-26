package com.vlasova.selenium.target;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


/**
 * @author vlasova
 */
public class TargetMainPageTest extends BaseSeleniumTest {
    private WebDriver webDriver;

    @BeforeMethod
    public void setUp() throws Exception {
        webDriver = getWebDriver();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        webDriver.quit();
    }

    @Test(description = "Launch browser and open URL http://www.target.com ")
    public void openMainPageTest() throws InterruptedException {
        webDriver.get(TargetWebsite.URL);
        assertThat(webDriver.getTitle(), equalTo(TargetWebsite.TITLE_MAIN_PAGE));
        Thread.sleep(5000);
    }

    @Test
    public void fillSearchTextField() throws InterruptedException {
        webDriver.get(TargetWebsite.URL);
        webDriver.findElement(By.id(TargetWebsite.SEARCH_LABEL)).click();
        Thread.sleep(1000);
        webDriver.findElement(By.id(TargetWebsite.SEARCH_TEXTFIELD)).sendKeys("dress");
        webDriver.findElement(By.id(TargetWebsite.SEARCH_TEXTFIELD)).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        assertThat(webDriver.getCurrentUrl(), equalTo(TargetWebsite.URL_AFTER_SEARCH + "dress"));
        assertThat(webDriver.getTitle(), equalTo("dress : Target"));
        Thread.sleep(5000);

        webDriver.quit();
    }
}
