package helpers;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelpers {
    public static String getLogin() {
        return user().userLogin();
    }
    public static String getPassword() {
        return user().userPwd();
    }
    public static String getToken() {
        return apiConfig().token();
    }
    public static String getBaseUri() {
        return apiConfig().baseUriWeather();
    }

    public static UserConfig user() {
        return ConfigFactory.newInstance().create(UserConfig.class);
    }

    public static APIConfig apiConfig() { return ConfigFactory.newInstance().create(APIConfig.class);
    }
}

// if (System.getProperty("environment") == null) System.setProperty("environment", "local");