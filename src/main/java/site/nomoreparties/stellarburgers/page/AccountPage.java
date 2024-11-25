package site.nomoreparties.stellarburgers.page;

import com.codeborne.selenide.SelenideElement;
import site.nomoreparties.stellarburgers.driver.DriverConfig;

import static com.codeborne.selenide.Selenide.$x;

public class AccountPage {
    public static final String URL = DriverConfig.BASE_URL + "/account";

    public SelenideElement menuProfile = $x("//a[text()='Профиль']");
    public SelenideElement buttonToConstructor = $x("//p[text()='Конструктор']/..");
    public SelenideElement buttonLogout = $x("//button[contains(@class, 'Account_button__14Yp3') and text()='Выход']");

}
