package pages;

import helper.CommonHelper;
import org.junit.Assert;
import org.openqa.selenium.By;
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
    @FindBy(css = "[class='elementor-button-link elementor-button elementor-size-sm']")
    private WebElement mainShopNowButton;
    @FindBy(css = "[id='custom_html-2'] [class='widget-title']")
    private WebElement contactInfoLabel;
    @FindBy(css = "[id='tg-scroll-to-top']")
    private WebElement scrollUpButton;
    @FindBy(css = "[id='menu-item-834']")
    private WebElement shopButton;

    public HomePage() {
        super(webDriver);
    }

    public void verifyHomePage(){
        waitUntilElementIsVisible(logo);
        waitUntilElementIsVisible(mainSliderHeader);
        waitUntilElementIsVisible(mainSliderImage);
    }

    public void goToShopNow(){
        waitUntilElementIsVisible(mainShopNowButton);
        mainShopNowButton.click();
    }

    public void verifyContactInfo() {
        waitUntilElementIsVisible(contactInfoLabel);
        Assert.assertTrue("Contact Info cannot be found", contactInfoLabel.isDisplayed());
    }

    public void backToTop() throws InterruptedException {
        waitUntilElementIsVisible(scrollUpButton);
        scrollUpButton.click();
        Thread.sleep(7000);
    }

    public void clickOnNavigationShopButton(){
        waitUntilElementIsVisible(shopButton);
        shopButton.click();
    }
}
