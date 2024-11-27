package site.nomoreparties.stellarburgers.page;

import com.codeborne.selenide.SelenideElement;
import site.nomoreparties.stellarburgers.driver.DriverConfig;

import static com.codeborne.selenide.Selenide.$x;

public class ForgotPasswordPage {
    public static final String URL = DriverConfig.BASE_URL + "/forgot-password";

    public final SelenideElement buttonLogin = $x("//a[text()='Войти']");
}
