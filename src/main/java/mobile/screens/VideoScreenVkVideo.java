package mobile.screens;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class VideoScreenVkVideo {
    private final SelenideElement currentVideoTime = $(AppiumBy.id("com.vk.vkvideo:id/current_progress"));
    private final SelenideElement videoPlayer = $(AppiumBy.id("com.vk.vkvideo:id/video_subtitles"));

    public boolean checkVideoPlay() {
        videoPlayer.shouldBe(visible).click();
        String startTimeString = currentVideoTime.shouldBe(visible).getText();

        Selenide.sleep(10000);

        videoPlayer.shouldBe(visible).click();
        String endTimeString= currentVideoTime.shouldBe(visible).getText();

        return !startTimeString.equals(endTimeString);
    }
}
