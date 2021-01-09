package helpers;

import org.aeonbits.owner.Config;

    @Config.LoadPolicy(Config.LoadType.MERGE)
    @Config.Sources({"system:properties",
                     //"classpath:api.properties",
                     "file:~/token.properties"})

    public interface APIConfig extends Config {

        @Key("token")
        String token();

        @Key("baseUriWeather")
        String baseUriWeather();
    }



