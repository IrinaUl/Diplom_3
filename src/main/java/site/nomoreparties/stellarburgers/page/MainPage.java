package site.nomoreparties.stellarburgers.page;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    public static final String TITLE_MAIN_PAGE = "Соберите бургер";

    public final SelenideElement buttonLogin = $x("//button[text()='Войти в аккаунт']");
    public final SelenideElement buttonToPersonalAccount = $x("//p[text()='Личный Кабинет']/..");
    public final SelenideElement titlePage = $x("//h1[contains(@class, 'text_type_main-large')]");
    public final SelenideElement buttonLogo = $x("//div[@class='AppHeader_header__logo__2D0X2']/a");
    public final SelenideElement buttonGoToBun = $x("//span[text()='Булки']/..");
    public final SelenideElement buttonGoToSouse = $x("//span[text()='Соусы']/..");
    public final SelenideElement buttonGoToFillings = $x("//span[text()='Начинки']/..");
    public final SelenideElement titleFilling = $x("//h2[text()='Начинки']");
    public final SelenideElement bunFirst = $x("//h2[text()='Булки']/following-sibling::ul/a[1]");
    public final SelenideElement souseFirst = $x("//h2[text()='Соусы']/following-sibling::ul/a[1]");
}
