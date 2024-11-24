package site.nomoreparties.stellarburgers.page;

import org.openqa.selenium.By;
import site.nomoreparties.stellarburgers.driver.DriverConfig;

public class AccountPage {
    public static final String URL = DriverConfig.BASE_URL + "/account";

    public By menuProfile = By.xpath("//a[@href='/account/profile']");
}
