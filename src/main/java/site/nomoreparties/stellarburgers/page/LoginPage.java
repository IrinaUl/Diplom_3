package site.nomoreparties.stellarburgers.page;

import org.openqa.selenium.By;
import site.nomoreparties.stellarburgers.driver.DriverConfig;

public class LoginPage {
    public static final String URL = DriverConfig.BASE_URL + "/login";

    public By email = By.xpath("//label[text()='Email']/../input");
    public By password = By.xpath("//label[text()='Пароль']/../input");
    public By buttonLogin = By.xpath("//button[contains(@class, 'button_button__33qZ0')]");

}
