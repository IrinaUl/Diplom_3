package site.nomoreparties.stellarburgers.page;

import com.codeborne.selenide.SelenideElement;
import site.nomoreparties.stellarburgers.driver.DriverConfig;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    public static final String URL = DriverConfig.BASE_URL + "/login";
    public static final String TITLE_LOGIN_PAGE = "Вход";

    public static SelenideElement email = $x("//label[text()='Email']/../input");
    public static SelenideElement password = $x("//label[text()='Пароль']/../input");
    public static SelenideElement buttonLogin = $x("//button[contains(@class, 'button_button__33qZ0') and text()='Войти']");
    public SelenideElement buttonRecoverPassword = $x("//p[text()='Забыли пароль?']/a");
    public SelenideElement title = $x("//div[@class='Auth_login__3hAey']/h2[text()='Вход']");

    public void login(String email, String password) {
        LoginPage.email.setValue(email);
        LoginPage.password.setValue(password);
        buttonLogin.click();
    }
}
