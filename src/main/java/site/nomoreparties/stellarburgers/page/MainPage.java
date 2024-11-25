package site.nomoreparties.stellarburgers.page;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    public final String TITLE_MAIN_PAGE = "Соберите бургер";

    public SelenideElement buttonLogin = $x("//button[text()='Войти в аккаунт']");
    public SelenideElement buttonToPersonalAccount = $x("//p[text()='Личный Кабинет']/..");
    public SelenideElement titlePage = $x("//h1[contains(@class, 'text_type_main-large')]");
    public SelenideElement buttonLogo = $x("//div[@class='AppHeader_header__logo__2D0X2']/a");
    public SelenideElement buttonGoToBun = $x("//span[text()='Булки']/..");
    public SelenideElement buttonGoToSouse = $x("//span[text()='Соусы']/..");
    public SelenideElement buttonGoToFillings = $x("//span[text()='Начинки']/..");
    public SelenideElement titleFilling = $x("//h2[text()='Начинки']");
    public SelenideElement bunFirst = $x("//h2[text()='Булки']/following-sibling::ul/a[1]");
    public SelenideElement souseFirst = $x("//h2[text()='Соусы']/following-sibling::ul/a[1]");
}
