package com.vlasova.selenium.target;

import com.vlasova.selenium.core.Credentials;
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
        webDriver.get(TargetWebsiteElements.URL);
        assertThat(webDriver.getTitle(), equalTo(TargetWebsiteElements.TITLE_MAIN_PAGE));
        Thread.sleep(5000);
    }

    @Test
    public void fillSearchTextField() throws InterruptedException {
        webDriver.get(TargetWebsiteElements.URL);
        webDriver.findElement(By.id(TargetWebsiteElements.SEARCH_LABEL)).click();
        Thread.sleep(1000);
        webDriver.findElement(By.id(TargetWebsiteElements.SEARCH_TEXTFIELD)).sendKeys("dress");
        webDriver.findElement(By.id(TargetWebsiteElements.SEARCH_TEXTFIELD)).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        assertThat(webDriver.getCurrentUrl(), equalTo(TargetWebsiteElements.URL_AFTER_SEARCH + "dress"));
        assertThat(webDriver.getTitle(), equalTo("dress : Target"));
        Thread.sleep(5000);
    }

    @Test
    public void addItemToCart() throws InterruptedException {
        String searchTarget = "Aveeno Baby Wash";
        webDriver.get(TargetWebsiteElements.URL);
        webDriver.findElement(By.id(TargetWebsiteElements.SEARCH_LABEL)).click();
        webDriver.findElement(By.id(TargetWebsiteElements.SEARCH_TEXTFIELD)).sendKeys(searchTarget);
        webDriver.findElement(By.id(TargetWebsiteElements.SEARCH_TEXTFIELD)).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        assertThat(webDriver.getCurrentUrl(),
                equalTo(TargetWebsiteElements.URL_AFTER_SEARCH + "Aveeno+Baby+Wash"));
        assertThat(webDriver.getTitle(), equalTo(searchTarget + " : Target"));
        Thread.sleep(5000);
        webDriver.findElement(By.className(TargetWebsiteElements.PRODUCT_LINK)).click();
        Thread.sleep(3000);
        webDriver.findElement(By.xpath(TargetWebsiteElements.ADD_TO_CART)).click();
        Thread.sleep(3000);
        webDriver.findElement(By.xpath(TargetWebsiteElements.VIEW_CART_AND_CHECKOUT)).click();
        Thread.sleep(3000);
        webDriver.findElement(By.className(TargetWebsiteElements.READY_TO_CHECKOUT)).click();
        assertThat(webDriver.getCurrentUrl(), equalTo(TargetWebsiteElements.SIGN_IN_OR_CREATE_AN_ACCOUNT_URL));
        Thread.sleep(2000);
    }


    @Test
    public void checkout() throws InterruptedException {
        addItemToCart();
        webDriver.findElement(By.id(TargetWebsiteElements.EMAIL_LOGIN)).sendKeys(Credentials.EMAIL);
        webDriver.findElement(By.id(TargetWebsiteElements.PASSWORD_LOGIN)).sendKeys(Credentials.PASSWORD);
        Thread.sleep(30000);

    }

    @Test
    public void createAnAccount() throws InterruptedException {
        webDriver.get(TargetWebsiteElements.URL);
        webDriver.findElement(By.id(TargetWebsiteElements.MY_ACCOUNT)).click();
        Thread.sleep(2000);
        webDriver.findElement(By.id(TargetWebsiteElements.SIGN_IN)).click();
        Thread.sleep(2000);
        webDriver.findElement(By.id(TargetWebsiteElements.CREATE_ACCOUNT)).click();
        webDriver.findElement(By.id(TargetWebsiteElements.EMAIL_TEXTFIELD)).sendKeys(Credentials.EMAIL);
        webDriver.findElement(By.id(TargetWebsiteElements.FIRST_NAME)).sendKeys(Credentials.FIRST_NAME);
        webDriver.findElement(By.id(TargetWebsiteElements.LAST_NAME)).sendKeys(Credentials.LAST_NAME);
        webDriver.findElement(By.id(TargetWebsiteElements.PASSWORD)).sendKeys(Credentials.PASSWORD);
        webDriver.findElement(By.id(TargetWebsiteElements.CREATE_ACCOUNT)).click();
        Thread.sleep(5000);
    }
}
