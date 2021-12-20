package steps;

import com.thoughtworks.gauge.Step;
import pages.ProductsPage;

public class ProductPageSteps {
    private ProductsPage productPage = new ProductsPage();

    @Step("Verify Products page is displayed")
    public void verifyProductsPage(){
        productPage.verifyProductsPage();}

    @Step("Go to basket")
    public void goToBasket(){
        productPage.goToBasket();
    }

    @Step("Add <index>st item to the basket")
    public void addFirstItemToBasket(int index) throws InterruptedException {
        productPage.addToCardButton(index-1);
    }

    @Step("Order by latest")
    public void orderByLatest() {
        productPage.clickOrderByLatest();
    }

    @Step("Go to Cart Page by <index>")
    public void goToCartPage(int index) {
        productPage.clickToViewCardButton(index-1);
    }
}
