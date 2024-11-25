package site.nomoreparties.stellarburgers.page;

import com.codeborne.selenide.SelenideElement;
import site.nomoreparties.stellarburgers.driver.DriverConfig;

import static com.codeborne.selenide.Selenide.$x;

public class RegistrationPage {
    public static final String URL = DriverConfig.BASE_URL + "/register";

    public SelenideElement name = $x("//label[text()='Имя']/../input");
    public SelenideElement email = $x("//label[text()='Email']/../input");
    public SelenideElement password = $x("//label[text()='Пароль']/../input");
    public SelenideElement buttonRegister = $x("//button[text()='Зарегистрироваться']");
    public SelenideElement buttonLogin = $x("//a[text()='Войти']");
    /** Алерты */
    public SelenideElement errorMessage = $x("//p[@class='input__error text_type_main-default' and text()='Некорректный пароль']");
}
