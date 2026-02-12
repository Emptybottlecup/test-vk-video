package tests;

import mobile.AndroidDriverProvider;
import mobile.screens.vk.HomeScreenVkVideo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestVkPlayVideo extends BaseTest {

    @BeforeAll
    public static void configApp() {
        AndroidDriverProvider.appPackage = "com.vk.vkvideo";
        AndroidDriverProvider.appActivity = "com.vk.video.screens.main.MainActivity";
        setUp();
    }

    @Test
    public void testVideoPlay() {
        HomeScreenVkVideo homeScreenVkVideo = new HomeScreenVkVideo();
        Assertions.assertTrue(homeScreenVkVideo.skipAdvertisementAndAuthorization()
                .playVideo("Warcraft")
                .checkVideoPlay(false));
    }

    @Test
    public void testVideoNotPlay() {
        HomeScreenVkVideo homeScreenVkVideo = new HomeScreenVkVideo();
        Assertions.assertFalse(homeScreenVkVideo.skipAdvertisementAndAuthorization()
                        .playVideo("Warcraft")
                        .checkVideoPlay(true));
    }
}
