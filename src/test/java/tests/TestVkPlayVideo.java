package tests;

import com.codeborne.selenide.ex.ElementNotFound;
import mobile.screens.HomeScreenVkVideo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestVkPlayVideo extends BaseTest {
    @Test
    public void testVideoPlay() {
        HomeScreenVkVideo homeScreenVkVideo = new HomeScreenVkVideo();
        Assertions.assertTrue(homeScreenVkVideo.skipAdvertisementAndAuthorization()
                .playVideo("Warcraft")
                .checkVideoPlay());
    }

    @Test
    public void testVideoNotPlay() {
        HomeScreenVkVideo homeScreenVkVideo = new HomeScreenVkVideo();
        Assertions.assertThrows(ElementNotFound.class, () ->
                homeScreenVkVideo.skipAdvertisementAndAuthorization()
                        .notPlayVideo("Warcraft"));
    }
}
