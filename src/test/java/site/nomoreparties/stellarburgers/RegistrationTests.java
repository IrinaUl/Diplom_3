package site.nomoreparties.stellarburgers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.page.LoginPage;
import site.nomoreparties.stellarburgers.page.RegistrationPage;
import site.nomoreparties.stellarburgers.utils.RandomUtils;
import site.nomoreparties.stellarburgers.utils.Utils;

import static org.junit.Assert.*;
import static site.nomoreparties.stellarburgers.driver.DriverConfig.*;

public class RegistrationTests {
    private WebDriver driver;
    private Utils utils;
    private RegistrationPage registrationPage;

    @Before
    public void setUp() {
        driver = createWebDriver();
        registrationPage = new RegistrationPage();
        utils = new Utils();
        goToPage(registrationPage.URL);
    }

    @Test
    public void registrationTest() {
        utils.sendKeys(registrationPage.name, RandomUtils.cyrillic(5));
        utils.sendKeys(registrationPage.email, RandomUtils.randomEmail(7));
        utils.sendKeys(registrationPage.password, RandomUtils.randomPassword(RandomUtils.randomNumber(6, 10)));
        utils.clickButton(registrationPage.buttonRegister);
        assertEquals("Пользователь не смог зарегистрироваться", LoginPage.URL ,utils.getUrl());
    }

    @Test
    public void registrationTestWithInvalidPassword() {
        utils.sendKeys(registrationPage.name, RandomUtils.cyrillic(5));
        utils.sendKeys(registrationPage.email, RandomUtils.randomEmail(7));
        utils.sendKeys(registrationPage.password, RandomUtils.randomPassword(RandomUtils.randomNumber(1, 5)));
        utils.clickButton(registrationPage.buttonRegister);
        assertTrue(utils.isElementPresent(registrationPage.errorMessage));
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
