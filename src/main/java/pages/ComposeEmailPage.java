package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ComposeEmailPage extends PageObject {
    @FindBy(xpath = "//div[@data-type='to']//input")
    private WebElement toField;

    @FindBy(xpath = "//input[@name='Subject']")
    private WebElement subjectField;

    @FindBy(xpath = "//div[@role='textbox']")
    private WebElement bodyField;

    @FindBy(xpath = "//span[text()='Отправить']")
    private WebElement sendButton;

    public ComposeEmailPage(WebDriver driver) {
        super(driver);
    }

    public void fillToField(String recipient) {
        // Заполняем поле "Кому"
        toField.sendKeys(recipient);
    }

    public void fillSubjectField(String subject) {
        // Заполняем поле "Тема"
        subjectField.sendKeys(subject);
    }

    public void fillBodyField(String body) {
        // Заполняем поле "Текст письма"
        bodyField.sendKeys(body);
    }

    public void clickSendButton() {
        // Нажимаем кнопку "Отправить"
        wait.until(ExpectedConditions.elementToBeClickable(sendButton)).click();
    }
}
