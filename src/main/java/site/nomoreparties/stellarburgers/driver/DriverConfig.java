package site.nomoreparties.stellarburgers.driver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.*;

public class DriverConfig {
    protected static WebDriver driver;
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site";
    private static final boolean HEADLESS = true;

    public static WebDriver createWebDriver() {
        String browser = System.getProperty("browser");
        if (browser == null) {
            return startChromeDriverSelenide();
        }
        switch (browser) {
            case "yandex":
                return startYandexDriverSelenide();
            case "chrome":
                return startChromeDriverSelenide();
            default:
                return startChromeDriverSelenide();
        }
    }

    public static WebDriver startChromeDriverSelenide() {
        System.setProperty("webdriver.chrome.driver","src/main/java/site/nomoreparties/stellarburgers/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        if (HEADLESS) {
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
        }
        WebDriver driver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(driver);
        Configuration.timeout = 6000;
        Configuration.pageLoadTimeout = 8000;

        return driver;
    }

    public static WebDriver startYandexDriverSelenide() {
        System.setProperty("webdriver.chrome.driver","src/main/java/site/nomoreparties/stellarburgers/resources/chromedriver-128");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
        if (HEADLESS) {
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
        }
        WebDriver driver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(driver);
        Configuration.timeout = 6000;
        Configuration.pageLoadTimeout = 8000;

        return driver;
    }

    public static void goToPage(String url) {
        open(url);
    }
}
