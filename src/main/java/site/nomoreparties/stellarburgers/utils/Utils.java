package site.nomoreparties.stellarburgers.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import site.nomoreparties.stellarburgers.driver.DriverConfig;

public class Utils extends DriverConfig {

    public void sendKeys(By element, String key) {
        driver.findElement(element).sendKeys(key);
    }

    public void clickButton(By element) {
        driver.findElement(element).click();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isElementPresent(By element) {
//        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(driver.findElement(element)));
        return driver.findElement(element).isDisplayed();
    }

    public void waitTime() {

    }


}
