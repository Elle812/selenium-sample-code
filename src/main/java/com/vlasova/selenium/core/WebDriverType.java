package com.vlasova.selenium.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * @author vlasova
 */
public enum WebDriverType {
    CHROME {
        @Override
        public WebDriver getWebDriver() {
            return new ChromeDriver();
        }
    },
    SAFARI {
        @Override
        public WebDriver getWebDriver() {
            return new SafariDriver();
        }
    },
    FIREFOX {
        @Override
        public WebDriver getWebDriver() {
            return new FirefoxDriver();
        }
    };

    public abstract WebDriver getWebDriver();
}
