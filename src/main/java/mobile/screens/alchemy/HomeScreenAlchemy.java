package mobile.screens.alchemy;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HomeScreenAlchemy {
    private final SelenideElement playButton = $(AppiumBy.xpath("//y2.f1/android.view.View/android.view" +
            ".View/android.view.View/android.view.View[5]/android.widget.Button"));

    public GameSelectorScreenAlchemy openGameSelectorScreen() {
        playButton.shouldBe(visible).click();
        return new GameSelectorScreenAlchemy();
    }
}
