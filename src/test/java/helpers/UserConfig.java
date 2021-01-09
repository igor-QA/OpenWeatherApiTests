package helpers;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties",
                 "classpath:remote.properties",
                 "file:~/user.properties"})

public interface UserConfig extends Config {
    @Key("login")
    String userLogin();
    @Key("Pwd")
    String userPwd();
}


