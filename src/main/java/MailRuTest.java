import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ComposeEmailPage;
import pages.InboxPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class MailRuTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setup() {
        // Указываем путь к драйверу для браузера Chrome
        System.setProperty("webdriver.chrome.driver", System.getProperty("driver.path"));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void sendEmailTest() {
        // Открываем страницу mail.ru
        driver.get("https://mail.ru");

        // Вводим логин и пароль и нажимаем кнопку "Войти"
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(System.getProperty("user.username"), System.getProperty("user.password"));

        // Ожидаем загрузки страницы "Входящие"
        wait.until(ExpectedConditions.titleContains("Входящие"));

        // Нажимаем кнопку "Написать письмо"
        InboxPage inboxPage = new InboxPage(driver);
        inboxPage.clickComposeButton();

        // Заполняем поля "Кому", "Тема" и "Текст письма"
        ComposeEmailPage composeEmailPage = new ComposeEmailPage(driver);
        composeEmailPage.fillToField(System.getProperty("recipient.mail"));
        composeEmailPage.fillSubjectField("Test email");
        composeEmailPage.fillBodyField("Hello, this is a test email.");

        // Нажимаем кнопку "Отправить"
        composeEmailPage.clickSendButton();

        // Подтверждаем отправку письма
        WebElement confirm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(string(),'Письмо отправлено')]")));
        assert confirm.isDisplayed();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
