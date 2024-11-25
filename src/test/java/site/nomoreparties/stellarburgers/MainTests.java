package site.nomoreparties.stellarburgers;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import site.nomoreparties.stellarburgers.page.MainPage;
import site.nomoreparties.stellarburgers.utils.Utils;

import static org.junit.Assert.assertTrue;
import static site.nomoreparties.stellarburgers.driver.DriverConfig.*;

public class MainTests {
    private WebDriver driver;
    private MainPage mainPage;
    private Utils utils;

    @Before
    public void setUp() {
        driver = createWebDriver();
        mainPage = new MainPage();
        utils = new Utils(driver);
        goToPage(BASE_URL);
    }

    @Test
    @DisplayName("Переход к разделу «Соусы» на главной странице")
    @Description("Проверка работы перехода к разделу «Соусы» на главной странице")
    public void goToSouse() {
        mainPage.buttonGoToSouse.click();
        WebElement element = mainPage.souseFirst;
        utils.waitForFillingVisible(element);
        assertTrue("Раздел не отображается", utils.isVisible(element));
    }

    @Test
    @DisplayName("Переход к разделу «Начинки» на главной странице")
    @Description("Проверка работы перехода к разделу «Начинки» на главной странице")
    public void goToFillings() {
        mainPage.buttonGoToFillings.click();
        WebElement element = mainPage.titleFilling;
        utils.waitForFillingVisible(element);
        assertTrue("Раздел не отображается", utils.isVisible(element));
    }

    @Test
    @DisplayName("Переход к разделу «Булки» на главной странице")
    @Description("Проверка работы перехода к разделу «Булки» на главной странице")
    public void goToBun() {
        mainPage.buttonGoToFillings.click();
        mainPage.buttonGoToBun.click();
        WebElement element = mainPage.bunFirst;
        utils.waitForFillingVisible(element);
        assertTrue("Раздел не отображается", utils.isVisible(element));
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
