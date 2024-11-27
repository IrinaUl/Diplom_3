package site.nomoreparties.stellarburgers.page;

import com.codeborne.selenide.SelenideElement;
import site.nomoreparties.stellarburgers.driver.DriverConfig;

import static com.codeborne.selenide.Selenide.$x;

public class RegistrationPage {
    public static final String URL = DriverConfig.BASE_URL + "/register";

    public final SelenideElement name = $x("//label[text()='Имя']/../input");
    public final SelenideElement email = $x("//label[text()='Email']/../input");
    public final SelenideElement password = $x("//label[text()='Пароль']/../input");
    public final SelenideElement buttonRegister = $x("//button[text()='Зарегистрироваться']");
    public final SelenideElement buttonLogin = $x("//a[text()='Войти']");
    /** Алерты */
    public final SelenideElement errorMessage = $x("//p[@class='input__error text_type_main-default' and text()='Некорректный пароль']");
}
