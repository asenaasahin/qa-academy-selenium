package pages;

import helper.CommonHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static utils.Driver.webDriver;

public class ProductsPage extends CommonHelper {

    public ProductsPage() {
        super(webDriver);
    }

    @FindBy(css = "[class='tg-icon tg-icon-shopping-cart']")
    private WebElement shopBasket;
    @FindBy(css = "[class='woocommerce-result-count']")
    private WebElement productsResult;
    @FindBy(css = "[name='orderby']")
    private WebElement orderBy;
    @FindBy(css = "[data-product_id='204']")
    private WebElement secondItem;
    @FindBy(css = "[data-product_id='211']")
    private WebElement thirdItem;
    @FindBy(css = "[class*='add_to_cart_button']")
    private List<WebElement> addToCardButtons;
    @FindBy(css = "[title='View cart']")
    private List<WebElement> viewCardButtons;


    public void verifyProductsPage() {
        waitUntilElementIsVisible(productsResult);
    }

    public void goToBasket() {
        waitUntilElementIsVisible(shopBasket);
        shopBasket.click();
    }

    public void clickOrderByLatest() {
        waitUntilElementIsVisible(orderBy);
        Select select = new Select(orderBy);
        select.selectByVisibleText("Sort by latest");
    }

    public void addToCardButton(int index) throws InterruptedException {
        waitUntilElementIsVisible(addToCardButtons.get(index));
        addToCardButtons.get(index).click();
        Thread.sleep(5000);
    }

    public void clickToViewCardButton(int index){
        waitUntilElementIsVisible(viewCardButtons.get(index));
        viewCardButtons.get(index).click();
    }
}
