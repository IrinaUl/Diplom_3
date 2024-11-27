package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.api.UserResponse;
import site.nomoreparties.stellarburgers.api.model.User;
import site.nomoreparties.stellarburgers.driver.DriverConfig;
import site.nomoreparties.stellarburgers.page.*;
import site.nomoreparties.stellarburgers.utils.RandomUtils;

import static org.junit.Assert.*;
import static site.nomoreparties.stellarburgers.driver.DriverConfig.*;

public class LoginTests {
    private static WebDriver driver;
    private RegistrationPage registrationPage;
    private MainPage mainPage;
    private static User user;
    private static String token;
    private static UserResponse userResponse;
    private LoginPage loginPage;
    private AccountPage accountPage;
    private ForgotPasswordPage forgotPasswordPage;

    @BeforeClass
    public static void createNewUser() {
        user = new User().withEmail(RandomUtils.randomEmail(7))
                .withName(RandomUtils.cyrillic(5))
                .withPassword(RandomUtils.randomPassword(8));
        userResponse = new UserResponse();
        userResponse.create(user);
        token = userResponse.login(user).path("accessToken");
    }

    @Before
    public void setUp() {
        driver = createWebDriver();
        registrationPage = new RegistrationPage();
        mainPage = new MainPage();
        loginPage = new LoginPage();
        accountPage = new AccountPage();
        forgotPasswordPage = new ForgotPasswordPage();
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    @Description("Проверка возможности залогиниться по кнопке «Войти в аккаунт» на главной")
    public void loginMainPageButtonLogin() {
        goToPage(DriverConfig.BASE_URL);
        mainPage.buttonLogin.click();
        loginPage.email.setValue(user.getEmail());
        loginPage.password.setValue(user.getPassword());
        loginPage.buttonLogin.click();
        mainPage.buttonToPersonalAccount.shouldBe(Condition.visible).click();
        assertTrue("Не удалось залогиниться", accountPage.menuProfile.shouldBe(Condition.visible).exists());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    @Description("Проверка возможности залогиниться по кнопке «Личный кабинет»")
    public void loginMainPageButtonPersonalAccount() {
        goToPage(DriverConfig.BASE_URL);
        mainPage.buttonToPersonalAccount.click();
        loginPage.email.setValue(user.getEmail());
        loginPage.password.setValue(user.getPassword());
        loginPage.buttonLogin.click();
        mainPage.buttonToPersonalAccount.shouldBe(Condition.visible).click();
        assertTrue("Не удалось залогиниться", accountPage.menuProfile.shouldBe(Condition.visible).exists());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Проверка возможности залогиниться по кнопке в форме регистрации")
    public void loginRegistrationPageButtonLogin() {
        goToPage(RegistrationPage.URL);
        registrationPage.buttonLogin.click();
        loginPage.email.setValue(user.getEmail());
        loginPage.password.setValue(user.getPassword());
        loginPage.buttonLogin.click();
        mainPage.buttonToPersonalAccount.shouldBe(Condition.visible).click();
        assertTrue("Не удалось залогиниться", accountPage.menuProfile.shouldBe(Condition.visible).exists());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Проверка возможности залогиниться по кнопке восстановления пароля")
    public void loginLoginPageButtonRecoverPassword() {
        goToPage(LoginPage.URL);
        loginPage.buttonRecoverPassword.click();
        forgotPasswordPage.buttonLogin.click();
        loginPage.email.setValue(user.getEmail());
        loginPage.password.setValue(user.getPassword());
        loginPage.buttonLogin.click();
        mainPage.buttonToPersonalAccount.shouldBe(Condition.visible).click();
        assertTrue("Не удалось залогиниться", accountPage.menuProfile.shouldBe(Condition.visible).exists());
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @AfterClass
    public static void deleteNewUser() {
        if (token != null) {userResponse.delete(token);}
    }
}
