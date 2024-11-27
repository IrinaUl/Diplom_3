package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.api.UserResponse;
import site.nomoreparties.stellarburgers.api.model.User;
import site.nomoreparties.stellarburgers.page.*;
import site.nomoreparties.stellarburgers.utils.RandomUtils;

import static org.junit.Assert.assertTrue;
import static site.nomoreparties.stellarburgers.driver.DriverConfig.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class AccountTests {
    private static WebDriver driver;
    private MainPage mainPage;
    private static User user;
    private static String token;
    private static UserResponse userResponse;
    private static LoginPage loginPage;
    private AccountPage accountPage;

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
        goToPage(LoginPage.URL);
        loginPage = new LoginPage();
        loginPage.login(user.getEmail(), user.getPassword());
        mainPage = new MainPage();
        accountPage = new AccountPage();
    }

    @Test
    @DisplayName("Переход в личный кабинет")
    @Description("Проверка перехода по клику на кнопку «Личный кабинет»")
    public void goToAccountPage() {
        mainPage.buttonToPersonalAccount.shouldBe(Condition.visible).click();
        assertTrue("Личный кабинет не доступен", accountPage.menuProfile.shouldBe(Condition.visible).exists());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор")
    @Description("Проверка перехода по клику на кнопку «Конструктор» на главную страницу в раздел Конструктор'")
    public void goToConstructor() {
        mainPage.buttonToPersonalAccount.click();
        accountPage.buttonToConstructor.click();
        assertTrue("Конструктор не отобразился", mainPage.titlePage.shouldBe(Condition.visible).text().equals(mainPage.TITLE_MAIN_PAGE));
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор")
    @Description("Проверка перехода по клику на логотип Stellar Burgers на главную страницу в раздел Конструктор'")
    public void goToConstructorLogo() {
        mainPage.buttonToPersonalAccount.click();
        mainPage.buttonLogo.click();
        assertTrue("Конструктор не отобразился", mainPage.titlePage.shouldBe(Condition.visible).text().equals(mainPage.TITLE_MAIN_PAGE));
    }

    @Test
    @DisplayName("Выход из аккаунта")
    @Description("Проверка выход по кнопке 'Выйти' в личном кабинете")
    public void logout() {
        mainPage.buttonToPersonalAccount.shouldBe(Condition.visible).click();
        accountPage.buttonLogout.shouldBe(Condition.visible).click();
        assertTrue("Разлогиниться не получилось", loginPage.title.shouldBe(Condition.visible).text().equals(loginPage.TITLE_LOGIN_PAGE));
        assertTrue("Неверный url", url().equals(loginPage.URL));
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
