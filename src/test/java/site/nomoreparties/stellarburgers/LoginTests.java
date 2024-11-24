package site.nomoreparties.stellarburgers;

import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.api.UserResponse;
import site.nomoreparties.stellarburgers.api.model.User;
import site.nomoreparties.stellarburgers.driver.DriverConfig;
import site.nomoreparties.stellarburgers.page.AccountPage;
import site.nomoreparties.stellarburgers.page.LoginPage;
import site.nomoreparties.stellarburgers.page.MainPage;
import site.nomoreparties.stellarburgers.page.RegistrationPage;
import site.nomoreparties.stellarburgers.utils.RandomUtils;
import site.nomoreparties.stellarburgers.utils.Utils;

import static org.junit.Assert.*;
import static site.nomoreparties.stellarburgers.driver.DriverConfig.*;

public class LoginTests {
    private WebDriver driver;
    private Utils utils;
    private RegistrationPage registrationPage;
    private MainPage mainPage;
    private User user;
    private LoginPage loginPage;
    private AccountPage accountPage;

    @Before
    public void setUp() {
        driver = createWebDriver();
        registrationPage = new RegistrationPage();
        mainPage = new MainPage();
        utils = new Utils();
        loginPage = new LoginPage();
        accountPage = new AccountPage();
        user = new User().withEmail(RandomUtils.randomEmail(7))
                .withName(RandomUtils.cyrillic(5))
                .withPassword(RandomUtils.randomPassword(8));
        UserResponse userResponse = new UserResponse();
        Response response = userResponse.create(user);
    }

    @Test
    public void loginMainPage() {
        goToPage(DriverConfig.BASE_URL);
        utils.clickButton(mainPage.buttonLogin);
        utils.sendKeys(loginPage.email, user.getEmail());
        utils.sendKeys(loginPage.password, user.getPassword());
        utils.clickButton(loginPage.buttonLogin);
        utils.clickButton(mainPage.buttonToPersonalAccount);
        assertTrue(utils.isElementPresent(accountPage.menuProfile));
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
