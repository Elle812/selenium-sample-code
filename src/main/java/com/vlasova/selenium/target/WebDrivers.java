package com.vlasova.selenium.target;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * Created by vlasova on 9/24/17.
 */
public abstract class WebDrivers implements WebDriver {
    public WebDriver getBrowser(String browser) {
        if (browser.equals("chrome")) {

            return new ChromeDriver();
        }
        if (browser.equals("firefox")) {
            return new FirefoxDriver();
        } else return new SafariDriver();
    }
}
