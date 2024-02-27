package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.RemoteConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {
    static RemoteConfig config = ConfigFactory.create(RemoteConfig.class, System.getProperties());
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();
        // Set your access credentials
        caps.setCapability("browserstack.user", config.getUser());
        caps.setCapability("browserstack.key", config.getKey());

        // Set URL of the application under test
        caps.setCapability("apps", config.getApp());

        // Specify device and os_version for testing
        caps.setCapability("device", config.getDevice());
        caps.setCapability("os_version", config.getOsVersion());

        // Set other BrowserStack capabilities
        caps.setCapability("project", config.getProject());
        caps.setCapability("build", config.getBuild());
        caps.setCapability("name", config.getName());


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                     new URL(config.getBaseUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
}
