package helpers;

import org.aeonbits.owner.Config;
import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties",
                 "classpath:remote.properties"})
public interface WebDriverConfig extends Config {

    @Key("webdriver.base.url")
    String baseURL();

    //DefaultValue("CHROME")
    @Key("webdriver.browser.name")
    String browserName();

    @Key("webdriver.browser.version")
    String browserVersion();

    @Key("webdriver.remote")
    boolean remote();

    @Key("webdriver.remote.url")
    URL remoteURL();

}