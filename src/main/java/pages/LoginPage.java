package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends PageObject {
    @FindBy(className = "ph-login")
    private WebElement enterButton;

    @FindBy(xpath = "//iframe[@scrolling='no']")
    private WebElement loginIframe;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement loginField;

    @FindBy(xpath = "//button[@data-test-id='next-button']")
    private WebElement nextButton;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@data-test-id='submit-button']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {

        //Нажимаем кнопку "Войти"
        enterButton.click();

        // Меняем таргет драйвера на iframe
        driver.switchTo().frame(loginIframe);

        // Заполняем поле "Логин"
        loginField.sendKeys(username);

        // Нажимаем кнопку "Ввести пароль"
        nextButton.click();

        // Заполняем поле "Пароль"
        passwordField.sendKeys(password);

        // Нажимаем кнопку "Войти"
        loginButton.click();

        // Меняем таргет драйвера обратно
        driver.switchTo().defaultContent();
    }
}

