import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.ConfigHelpers;
import helpers.WebDriverConfig;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.WebDriverProvider;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;

public class WeatherTests {

    private static final WebDriverConfig webDriverConfig = ConfigFactory.newInstance().create(WebDriverConfig.class);
    private static final String LOGIN = ConfigHelpers.getLogin();
    private static final String PWD = ConfigHelpers.getPassword();

    @BeforeAll
    static void setup() {
        Configuration.browser = WebDriverProvider.class.getName();
        Configuration.baseUrl = webDriverConfig.baseURL();
        Configuration.startMaximized = true;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .savePageSource(true)
                .screenshots(true));

    }
    @Owner("Pavlov Igor")
    @Test
    public void SignInAccount() {

        open("https://openweathermap.org/");
        $("#sign_in").click();
        $("#user_email").val(LOGIN);
        $("#user_password").val(PWD);
        $(byValue("Submit")).click();
        $(" div.panel-body").shouldHave(text("Signed in successfully."));

    }
}


