package config;
import org.aeonbits.owner.Config;

@Config.Sources({"classpath:properties/remote.properties"})
public interface RemoteConfig extends Config {
    @Key("user")
    String getUser();

    @Key("key")
    String getKey();

    @Key("apps")
    String getApp();

    @Key("device")
    String getDevice();

    @Key("osVersion")
    String getOsVersion();

    @Key("baseUrl")
    String getBaseUrl();

    @Key("project")
    String getProject();

    @Key("build")
    String getBuild();

    @Key("name")
    String getName();
}
