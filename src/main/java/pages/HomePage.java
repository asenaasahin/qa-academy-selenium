package pages;

import helper.CommonHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static utils.Driver.webDriver;

public class HomePage extends CommonHelper {
    @FindBy(css = "[class='custom-logo']")
    private WebElement logo;
    @FindBy(css = "[class='attachment-full size-full']")
    private WebElement mainSliderImage;
    @FindBy(css = "[data-id='ad0d123'] [data-id='8a7258b']")
    private WebElement mainSliderHeader;

    public HomePage() {
        super(webDriver);
    }

    public void verifyHomePage(){
        waitUntilElementIsVisible(logo);
        waitUntilElementIsVisible(mainSliderHeader);
        waitUntilElementIsVisible(mainSliderImage);
    }
}
