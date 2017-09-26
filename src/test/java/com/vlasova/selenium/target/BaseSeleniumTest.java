package com.vlasova.selenium.target;

import com.vlasova.selenium.core.WebDriverType;
import org.openqa.selenium.WebDriver;

import java.nio.file.Paths;

/**
 * @author vlasova
 */
public abstract class BaseSeleniumTest {
    private static final WebDriverType WEB_DRIVER_TYPE;

    static {
        String webDriverName = System.getenv("WEB_DRIVER");
        if (webDriverName == null) {
            webDriverName = "CHROME";
        }
        WEB_DRIVER_TYPE = WebDriverType.valueOf(webDriverName);

        String pathToChromeDriverBinary = Paths.get(System.getProperty("user.dir"), "dist", "chromedriver").toString();
        System.setProperty("webdriver.chrome.driver", pathToChromeDriverBinary);
    }

    protected WebDriver getWebDriver() {
        return WEB_DRIVER_TYPE.getWebDriver();
    }
}

