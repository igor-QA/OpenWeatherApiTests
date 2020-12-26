import com.codeborne.selenide.Configuration;
import helpers.ConfigHelpers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;

public class WeatherTests {
    //final WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class);

    @BeforeAll
    static void setup() {
        Configuration.browser = ConfigHelpers.getRemote();
        Configuration.startMaximized = true;
    }

    private static final String LOGIN = ConfigHelpers.getLogin();
    private static final String PWD = ConfigHelpers.getPassword();

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









