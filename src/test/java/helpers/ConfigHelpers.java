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
        return api().token();
    }
    public static String getRemote() {
        return driver().remote();
    }


    public static UserConfig user() {
        return ConfigFactory.newInstance().create(UserConfig.class);
    }
    public static APIConfig api() {
        return ConfigFactory.newInstance().create(APIConfig.class);
    }
    public static WebDriverConfig driver() {
                return ConfigFactory.newInstance().create(WebDriverConfig.class);

    }
}