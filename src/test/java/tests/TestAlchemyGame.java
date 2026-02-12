package tests;

import mobile.AndroidDriverProvider;
import mobile.screens.alchemy.HomeScreenAlchemy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestAlchemyGame extends BaseTest{

    @BeforeAll
    public static void configApp() {
        AndroidDriverProvider.appPackage = "com.ilyin.alchemy";
        AndroidDriverProvider.appActivity = "com.ilyin.app_google_core.GoogleAppActivity";
        setUp();
    }

    @Test
    public void checkFourHints() {
        HomeScreenAlchemy homeScreenAlchemy = new HomeScreenAlchemy();
        Assertions.assertTrue(homeScreenAlchemy.openGameSelectorScreen()
                .openAddVideo()
                .closeAd()
                .checkFourHintsOnScreen());
    }
}
