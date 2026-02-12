package mobile.screens.vk;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class VideoScreenVkVideo {
    private final SelenideElement currentVideoTime = $(AppiumBy.id("com.vk.vkvideo:id/current_progress"));
    private final SelenideElement videoPlayer = $(AppiumBy.id("com.vk.vkvideo:id/video_subtitles"));
    private final SelenideElement playButton = $(AppiumBy.id("com.vk.vkvideo:id/video_play_button"));

    public boolean checkVideoPlay(boolean isNotPlay) {
        videoPlayer.shouldBe(visible).click();

        if (isNotPlay) {
            playButton.shouldBe(visible).click();
        }

        String startTimeString = currentVideoTime.shouldBe(visible).getText();

        Selenide.sleep(10000);

        if(!isNotPlay) {
            videoPlayer.shouldBe(visible).click();
        }

        String endTimeString = currentVideoTime.shouldBe(visible).getText();

        return !startTimeString.equals(endTimeString);
    }
}
