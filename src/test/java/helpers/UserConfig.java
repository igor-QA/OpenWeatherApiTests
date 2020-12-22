package helpers;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:user.properties",
        "file:~/user.properties"})

public interface UserConfig extends Config {
    @Key("login")
    String userLogin();
    @Key("Pwd")
    String userPwd();
}
