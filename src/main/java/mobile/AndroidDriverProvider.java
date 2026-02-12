package mobile;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class AndroidDriverProvider implements WebDriverProvider {
    private final Properties config = new Properties();

    public static String appPackage;
    public static String appActivity;

    public AndroidDriverProvider() {
        setConfig();
    }

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setDeviceName(config.getProperty("device.name"));
        options.setPlatformName(config.getProperty("platform.name"));
        options.setAutomationName(config.getProperty("automation.name"));
        options.setAppPackage(appPackage);
        options.setAppActivity(appActivity);
        options.setNewCommandTimeout(Duration.ofSeconds(Long.parseLong(config.getProperty("new.command.timeout"))));

        try {
            URI appiumServerURI = new URI(config.getProperty("appium.server.url"));
            URL appiumServerURL = appiumServerURI.toURL();
            return new AndroidDriver(appiumServerURL, options);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Некорректный URL для Appium сервера", e);
        } catch (URISyntaxException e) {
            throw new RuntimeException("Некорректный URI для Appium сервера", e);
        }
    }

    private void setConfig() {
        try(InputStream input = AndroidDriverProvider.class.getClassLoader().getResourceAsStream("config.properties")) {
            config.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Не получилось загрузить данные из config.properties");
        }
    }
}