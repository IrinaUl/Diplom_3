package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.page.LoginPage;
import site.nomoreparties.stellarburgers.page.RegistrationPage;
import site.nomoreparties.stellarburgers.utils.RandomUtils;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.*;
import static site.nomoreparties.stellarburgers.driver.DriverConfig.*;

public class RegistrationTests {
    private WebDriver driver;
    private RegistrationPage registrationPage;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        driver = createWebDriver();
        registrationPage = new RegistrationPage();
        loginPage = new LoginPage();
        goToPage(registrationPage.URL);
    }

    @Test
    @DisplayName("Регистрация на сайте")
    @Description("Проверка успешной регистрации на сайте нового пользователя")
    public void registrationTest() {
        registrationPage.name.setValue(RandomUtils.cyrillic(5));
        registrationPage.email.setValue(RandomUtils.randomEmail(7));
        registrationPage.password.setValue(RandomUtils.randomPassword(RandomUtils.randomNumber(6, 10)));
        registrationPage.buttonRegister.click();
        loginPage.title.shouldBe(Condition.visible);
        assertEquals("Пользователь не смог зарегистрироваться", LoginPage.URL, url());
    }

    @Test
    @DisplayName("Ввод некорректного пароля")
    @Description("Проверка валидации длины пароля. Минимальный пароль — шесть символов")
    public void registrationTestWithInvalidPassword() {
        registrationPage.name.setValue(RandomUtils.cyrillic(5));
        registrationPage.email.setValue(RandomUtils.randomEmail(7));
        registrationPage.password.setValue(RandomUtils.randomPassword(RandomUtils.randomNumber(1, 5)));
        registrationPage.buttonRegister.click();
        assertTrue("Отсутствует предупреждающее сообщение", registrationPage.errorMessage.isDisplayed());
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
