import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.restassured.AllureRestAssured;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class WeatherApiTests {
    private static final String TOKEN = "0a843f1a8f978cf84fe6af0963499842";
    private static final String LAT = "33.441792";
    private static final String LON = "-94.037689";

    @BeforeEach
    public void initListener() {
        SelenideLogger.addListener("allure", new AllureSelenide()
                .savePageSource(true)
                .screenshots(true));
    }

    @Test
    void RequestWeather (String LAT, String LON, String TOKEN) {
        // @formatter:off
        given()
                .filter(new AllureRestAssured())
                //.baseUri("https://openweathermap.org/api");
                .baseUri("api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}");
        when().
                get("/weather")
        .then()
                .log().body()
                .body("weather.id", equalTo(701));
    }

        // @formatter:on
}



