package helper;

import com.github.webdriverextensions.WebDriverExtensionFieldDecorator;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class CommonHelper {
    private WebDriver webDriver;
    private WebDriverWait wait;
    int counter = 0;

    public CommonHelper(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(new WebDriverExtensionFieldDecorator(webDriver), this);
        wait = new WebDriverWait(webDriver, 10);
    }

    public WebElement waitUntilElementIsVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element;
        } catch (StaleElementReferenceException e) {
            counter++;
            System.out.println(counter);
            System.out.println(e);
            return waitUntilElementIsVisible(element);
        }
    }
}
