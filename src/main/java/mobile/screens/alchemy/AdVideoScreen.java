package mobile.screens.alchemy;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AdVideoScreen {

    private final SelenideElement textWithHints = $(AppiumBy.xpath("//android.widget.TextView[@text" +
            "=\"Your hints\"]"));

    private final SelenideElement closeAdButton1 = $(AppiumBy.id("com.ilyin.alchemy:id/bigo_ad_btn_close"));
    private final SelenideElement closeAdButton2 =  $(AppiumBy.xpath("//android.widget.RelativeLayout" +
            "[@content-desc=\"pageIndex: 1\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view" +
            ".ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget" +
            ".ImageView"));
    private final SelenideElement closeAdButton3 =  $(AppiumBy.xpath("//android.widget.RelativeLayout" +
            "[@content-desc=\"pageIndex: 2\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view" +
            ".ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget" +
            ".ImageView"));
    private final SelenideElement closeAdButton4 = $(AppiumBy.id("com.ilyin.alchemy:id/mbridge_windwv_close"));
    private final SelenideElement closeAdButton5 = $(AppiumBy.id("m-playable-skip"));
    private final SelenideElement closeAdButton6 = $(AppiumBy.id("m-playable-close"));

    public GameSelectorScreenAlchemy closeAd () {
        long endTime = System.currentTimeMillis() + 120000;

        while (System.currentTimeMillis() < endTime) {
            if(textWithHints.is(visible)) {
                return new GameSelectorScreenAlchemy();
            }

            if(closeAdButton1.is(visible)) {
                closeAdButton1.click();
            } else if(closeAdButton2.is(visible)) {
                closeAdButton2.click();
            } else if(closeAdButton3.is(visible)) {
                closeAdButton3.click();
            } else if(closeAdButton4.is(visible)) {
                closeAdButton4.click();
            } else if(closeAdButton5.is(visible)) {
                closeAdButton5.click();
            } else if(closeAdButton6.is(visible)) {
                closeAdButton6.click();
            }

            Selenide.sleep(500);
        }
        throw new RuntimeException("Реклама идет больше 2 минут");
    }
}
