import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.restassured.AllureRestAssured;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class WeatherApiTests {
    String TOKEN = "1dd8d324030587f090f61a2228ec79db";
    String LAT = "33.441792";
    String LON = "-94.037689";
    String apiRequest = "lat=" + LAT + "&lon=" + LON + "&appid=" + TOKEN;
    String baseUri = "http://api.openweathermap.org/data/2.5/weather?";

    @BeforeEach
    public void initListener() {
        SelenideLogger.addListener("allure", new AllureSelenide()
                .savePageSource(true)
                .screenshots(true));
    }
    @Test
    @DisplayName("Current and forecast weather data")
    void requestWeatherId() {
        // @formatter:off

        given()
                .filter(new AllureRestAssured())
                .baseUri("http://api.openweathermap.org/data/2.5/weather?")
                .log().uri()
        .when().
                get(baseUri + apiRequest )

        .then()
                .log().body()
                .body("weather.id.find()", is(equalTo(800)));

    }
        // @formatter:on
}