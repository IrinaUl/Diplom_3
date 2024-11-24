package site.nomoreparties.stellarburgers.page;

import org.openqa.selenium.By;
import site.nomoreparties.stellarburgers.driver.DriverConfig;

public class RegistrationPage {
    public static final String URL = DriverConfig.BASE_URL + "/register";

    public By name = By.xpath("//label[text()='Имя']/../input");
    public By email = By.xpath("//label[text()='Email']/../input");
    public By password = By.xpath("//label[text()='Пароль']/../input");
    public By buttonRegister = By.xpath("//a[@href='/account']");
    public By errorMessage = By.xpath("//p[@class='input__error text_type_main-default' and text()='Некорректный пароль']");
}
