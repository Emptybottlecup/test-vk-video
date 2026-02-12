package mobile.screens.alchemy;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class GameSelectorScreenAlchemy {
    private final SelenideElement hintButton = $(AppiumBy.xpath("//y2.f1/android.view.View/android.view" +
            ".View/android.view.View/android.view.View[1]/android.view.View[1]/android.widget.Button"));

    private final SelenideElement adButton = $(AppiumBy.xpath("//android.widget.TextView[@text=\"Watch\"]"));

    private final SelenideElement textWithFourHints = $(AppiumBy.xpath("//android.widget.TextView" +
            "[@text=\"4\"]"));

    public AdVideoScreen openAddVideo() {
        hintButton.shouldBe(visible).click();
        adButton.shouldBe(visible, Duration.ofSeconds(30)).click();
        return new AdVideoScreen();
    }

    public boolean checkFourHintsOnScreen() {
        return textWithFourHints.is(visible);
    }
}
