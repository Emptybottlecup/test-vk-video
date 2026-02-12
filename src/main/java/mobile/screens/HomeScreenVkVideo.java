package mobile.screens;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.NetworkSpeed;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class HomeScreenVkVideo {
    private final SelenideElement skipAuthorization = $(AppiumBy.id("com.vk.vkvideo:id/fast_login_tertiary_btn"));
    private final SelenideElement closeAdvertisement = $(AppiumBy.id("com.vk.vkvideo:id/close_btn_left"));
    private final SelenideElement searchButton = $(AppiumBy.id("com.vk.vkvideo:id/search_button"));
    private final SelenideElement searchQuery = $(AppiumBy.id("com.vk.vkvideo:id/query"));
    private final SelenideElement firstSuggestion  = $(AppiumBy.xpath("(//android.widget.Button" +
            "[@resource-id=\"com.vk.vkvideo:id/search_suggestion\"])[1]"));
    private final SelenideElement firstVideo = $(AppiumBy.id("com.vk.vkvideo:id/video_subtitles"));

    public HomeScreenVkVideo skipAdvertisementAndAuthorization() {
        AndroidDriver driver = (AndroidDriver) WebDriverRunner.getWebDriver();
        driver.setNetworkSpeed(NetworkSpeed.LTE);
        long endTime = System.currentTimeMillis() + 60000;
        while (System.currentTimeMillis() < endTime) {
            if (closeAdvertisement.is(visible)) {
                closeAdvertisement.click();
            } else if (skipAuthorization.is(visible)) {
                skipAuthorization.click();
            } else if (searchButton.is(visible)) {
                searchButton.click();
                return this;
            }
            Selenide.sleep(500);
        }
        throw new RuntimeException("Главный экран VK Video не загрузился за 20 секунд!");
    }

    public VideoScreenVkVideo playVideo(String videoName) {
        searchQuery.shouldBe(visible).setValue(videoName);
        firstSuggestion.shouldBe(visible).click();
        firstVideo.shouldBe(visible).click();
        return new VideoScreenVkVideo();
    }

    public void notPlayVideo(String videoName) {
        searchQuery.shouldBe(visible).setValue(videoName);
        firstSuggestion.shouldBe(visible).click();

        AndroidDriver driver = (AndroidDriver) WebDriverRunner.getWebDriver();
        driver.toggleWifi();
        driver.toggleData();

        firstVideo.shouldBe(visible).click();
    }
}
