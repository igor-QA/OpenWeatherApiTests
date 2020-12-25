/*
package utils;

import com.codeborne.selenide.WebDriverProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;


public class CustomWebDriver implements WebDriverProvider {

        @Nonnull
        @Override
        public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
            desiredCapabilities.setVersion(config.browserVersion());

            switch (config.browserName()) {
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    return new ChromeDriver(getChromeOptions().merge(desiredCapabilities));
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    return new FirefoxDriver(getFirefoxOptions().merge(desiredCapabilities));
                default:
                    throw new RuntimeException("Unknown browser: " + config.browserName());
            }
        }

        private FirefoxOptions getFirefoxOptions() {
            FirefoxOptions firefoxOptions = new FirefoxOptions().setAcceptInsecureCerts(true);
            return firefoxOptions;
        }

    private WebDriver getLocalChromeDriver(DesiredCapabilities capabilities) {
        return new ChromeDriver(capabilities);
    }

    private WebDriver getRemoteWebDriver(DesiredCapabilities capabilities) {
        RemoteWebDriver remoteWebDriver = new RemoteWebDriver(getRemoteWebdriverUrl(), capabilities);
        remoteWebDriver.setFileDetector(new LocalFileDetector());
        return remoteWebDriver;
    }

    private URL getRemoteWebdriverUrl() {
        try {
            return new URL(remoteDriverUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}




}


 */


