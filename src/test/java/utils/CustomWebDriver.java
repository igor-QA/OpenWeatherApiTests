package utils;

import helpers.WebDriverConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.codeborne.selenide.Browsers.*;
import static utils.BrowserOptions.*;

public class CustomWebDriver {

    final WebDriverConfig webDriverConfig = ConfigFactory.newInstance().create(WebDriverConfig.class);


    public RemoteWebDriver getChromeRemote() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(CHROME);
        capabilities.setVersion(webDriverConfig.browserVersion());
        capabilities.setCapability(ChromeOptions.CAPABILITY, getChromeOptions());

        return new RemoteWebDriver(webDriverConfig.remoteURL(), capabilities);
    }

    protected RemoteWebDriver getFirefoxRemote() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(FIREFOX);
        capabilities.setVersion(webDriverConfig.browserVersion());
        capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, getFirefoxOptions());

        return new RemoteWebDriver(webDriverConfig.remoteURL(), capabilities);
    }

    protected RemoteWebDriver getOperaRemote() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(OPERA);
        capabilities.setVersion(webDriverConfig.browserVersion());
        capabilities.setCapability(OperaOptions.CAPABILITY, getOperaOptions());

        return new RemoteWebDriver(webDriverConfig.remoteURL(), capabilities);
    }

    protected WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().driverVersion(webDriverConfig.browserVersion()).setup();
        return new ChromeDriver();
    }

    protected WebDriver getFirefoxDriver() {
        WebDriverManager.firefoxdriver().driverVersion(webDriverConfig.browserVersion()).setup();
        return new FirefoxDriver();
    }

    protected WebDriver getOperaDriver() {
        WebDriverManager.operadriver().driverVersion(webDriverConfig.browserVersion()).setup();
        return new OperaDriver();
    }
}


/*
 //WebDriverManager.chromedriver().setup();
         return new ChromeDriver(getChromeOptions().merge(desiredCapabilities));
         case FIREFOX:
         WebDriverManager.firefoxdriver().setup();
         return new FirefoxDriver(getFirefoxOptions().merge(desiredCapabilities));


 */