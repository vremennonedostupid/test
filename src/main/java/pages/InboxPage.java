package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InboxPage extends PageObject {
    @FindBy(xpath = "//span[text()='Написать письмо']")
    private WebElement composeButton;

    public InboxPage(WebDriver driver) {
        super(driver);
    }

    public void clickComposeButton() {
        // Нажимаем кнопку "Написать письмо"
        wait.until(ExpectedConditions.elementToBeClickable(composeButton)).click();
    }
}
