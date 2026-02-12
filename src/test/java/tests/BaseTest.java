package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.appium.SelenideAppium;
import io.appium.java_client.android.AndroidDriver;
import mobile.AndroidDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    @BeforeAll
    public static void setUp() {
        Configuration.browser = AndroidDriverProvider.class.getName();
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }

    @BeforeEach
    public void startApp() {
        SelenideAppium.launchApp();
    }

    @AfterEach
    public void tearDown() {
        AndroidDriver driver = (AndroidDriver) WebDriverRunner.getWebDriver();

        if (!driver.getConnection().isDataEnabled()) {
            driver.toggleData();
        }

        if (!driver.getConnection().isWiFiEnabled()) {
            driver.toggleWifi();
        }

        Selenide.closeWebDriver();
    }
}