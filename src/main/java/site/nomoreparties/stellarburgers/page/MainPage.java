package site.nomoreparties.stellarburgers.page;

import org.openqa.selenium.By;

public class MainPage {
    public By buttonLogin = By.xpath("//button[text()='Войти в аккаунт']");
    public By buttonToPersonalAccount = By.xpath("//a[@href='/account']");
}
