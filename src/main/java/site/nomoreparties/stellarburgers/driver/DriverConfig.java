package site.nomoreparties.stellarburgers.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DriverConfig {
    protected static WebDriver driver;
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site";

    public static WebDriver createWebDriver() {
        String browser = System.getProperty("browser");
        if (browser == null) {
            return startChromeDriver();
        }

        switch (browser) {
            case "yandex":
                return startYandexDriver();
            case "chrome":
            default:
                return startChromeDriver();
        }
    }

    public static WebDriver startChromeDriver() {
        System.setProperty("webdriver.chrome.driver","src/main/java/site/nomoreparties/stellarburgers/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000,
                TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(10000,
                TimeUnit.MILLISECONDS);
        driver.manage().timeouts().setScriptTimeout(5000,
                TimeUnit.MILLISECONDS);
        return driver;
    }

    public static WebDriver startYandexDriver() {
        System.setProperty("webdriver.chrome.driver","src/main/java/site/nomoreparties/stellarburgers/resources/chromedriver-128");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
        return driver = new ChromeDriver(options);
    }

    public static void goToPage(String url) {
       driver.get(url);
    }
}
