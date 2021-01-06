import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.ConfigHelpers;
import io.qameta.allure.restassured.AllureRestAssured;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class WeatherApiTests {

    //private static final APIConfig apiConfig = ConfigFactory.create(APIConfig.class);
    private final String TOKEN = ConfigHelpers.getToken();
    private final String baseUriWeather = ConfigHelpers.getBaseUri();

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
        Map<String, String> params = new HashMap<>();
        String LAT = "33.441792";
        params.put("lat", LAT);
        String LON = "-94.037689";
        params.put("lon", LON);
        params.put("appid", TOKEN);

        given()
                .queryParams(params)
                .filter(new AllureRestAssured())
                .baseUri(baseUriWeather)
                .log().uri()
        .when().
                get()

        .then()
                .log().body()
                .body("weather.id.find()", is(equalTo(801)));
    }
        // @formatter:on
}