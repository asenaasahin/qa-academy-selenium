package pages;

import helper.CommonHelper;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static utils.Driver.webDriver;

public class CartPage extends CommonHelper {

    public CartPage() {
        super(webDriver);
    }

    @FindBy(xpath = "//td[@data-title='Product']//a")
    private List<WebElement> cartItem;
    @FindBy(css = "[id*='quantity']")
    private WebElement firstItemQuantity;
    @FindBy(css = "[name='update_cart']")
    private WebElement updateCartButton;
    @FindBy(css = "[class='remove']")
    private List<WebElement> removeButtons;
    @FindBy(css = "[class='cart-subtotal'] [class*='woocommerce-Price-amount']")
    private WebElement cardSubTotal;
    @FindBy(css = "[class='cart-empty woocommerce-info']")
    private WebElement cardPageInfoLabel;
    @FindBy(css = "[class='tg-page-header__title']")
    private WebElement cardPageLabel;
    @FindBy(css = "[data-title='Price'] [class*='amount']")
    private List<WebElement> priceOfProducts;
    @FindBy(css = "[class='checkout-button button alt wc-forward']")
    private WebElement proceedCheckoutButton;
    @FindBy(css = "[id='billing_first_name']")
    private WebElement firstName;
    @FindBy(css = "[id='billing_last_name']")
    private WebElement lastName;
    @FindBy(css = "[id='billing_address_1']")
    private WebElement address;
    @FindBy(css = "[id='billing_postcode']")
    private WebElement postCode;
    @FindBy(css = "[id='billing_city']")
    private WebElement town;
    @FindBy(css = "[id='billing_phone']")
    private WebElement phone;
    @FindBy(css = "[id='billing_email']")
    private WebElement mail;
    @FindBy(css = "[id='mailpoet_woocommerce_checkout_optin']")
    private WebElement consentFormButton;
    @FindBy(css = "[id='order_comments']")
    private WebElement orderNote;

    public void verifyItemAdded(String itemName,int index) throws InterruptedException {
        Thread.sleep(4000);
        waitUntilElementIsVisible(cartItem.get(index));
        Assert.assertEquals(cartItem.get(index).getText(), itemName);
    }

    public void increaseQuantity() {
        firstItemQuantity.clear();
        firstItemQuantity.sendKeys("3");
    }

    public void updateCart() {
        updateCartButton.click();
    }

    public void deleteItem(int index) throws InterruptedException {
        waitUntilElementIsVisible(removeButtons.get(index));
        removeButtons.get(index).click();
        Thread.sleep(4000);
    }

    public void verifyTotalBasketPrice(String totalPrice) throws InterruptedException {
        waitUntilElementIsVisible(cardSubTotal);
        Thread.sleep(4000);
        Assert.assertTrue("Total basket price is not verified", cardSubTotal.getText().contains(totalPrice));
    }

    public void verifyCardIsEmpty(){
        waitUntilElementIsVisible(cardPageInfoLabel);
        Assert.assertEquals(cardPageInfoLabel.getText(), "Your cart is currently empty.");
    }

    public void verifyCartPageIsDisplayed(){
        waitUntilElementIsVisible(cardPageLabel);
        Assert.assertTrue("Cart Page cannot be displayed", cardPageLabel.isDisplayed());
    }

    public void proceedCheckout(){
        waitUntilElementIsVisible(proceedCheckoutButton);
        proceedCheckoutButton.click();
    }

    public void fillForm() throws InterruptedException {
        waitUntilElementIsVisible(firstName);
        firstName.sendKeys("asena");
        waitUntilElementIsVisible(lastName);
        lastName.sendKeys("sahin");
        waitUntilElementIsVisible(address);
        address.sendKeys("emirler");
        waitUntilElementIsVisible(postCode);
        postCode.sendKeys("09400");
        waitUntilElementIsVisible(town);
        town.sendKeys("aydin");
        waitUntilElementIsVisible(phone);
        phone.sendKeys("222222222");
        waitUntilElementIsVisible(mail);
        mail.sendKeys("asena.sahin@getir.com");
        waitUntilElementIsVisible(orderNote);
        orderNote.sendKeys("naber");
        scrollDown();
        Thread.sleep(5000);
        waitUntilElementIsVisible(consentFormButton);
        consentFormButton.click();
    }
}
