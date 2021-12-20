package steps;

import com.thoughtworks.gauge.Step;
import pages.CartPage;
import pages.HomePage;

public class CartPageSteps {
    CartPage cartPage = new CartPage();

    @Step("Refresh basket page")
    public void refreshBasketPage() {
        cartPage.pageRefresh();
    }

    @Step("Verify <itemName> item is added to the basket by <index>")
    public void verifyItemAdded(String itemName, int index) throws InterruptedException {
        cartPage.verifyItemAdded(itemName, index - 1);
    }

    @Step("Increase added product quantity to 3")
    public void increaseQuantity() {
        cartPage.increaseQuantity();
    }

    @Step("Update Cart button is clicked")
    public void updateCart() {
        cartPage.updateCart();
    }

    @Step("<index> item that added is deleted")
    public void deleteItem(int index) throws InterruptedException {
        cartPage.deleteItem(index - 1);
    }

    @Step("Verify Card Total Price is <totalPrice>")
    public void verifyTotalBasketPrice(String totalPrice) throws InterruptedException {
        cartPage.verifyTotalBasketPrice(totalPrice);
    }

    @Step("Verify Card is Empty")
    public void verifyCardIsEmpty() {
        cartPage.verifyCardIsEmpty();
    }

    @Step("Verify Card Page is displayed")
    public void verifyCartPage() {
        cartPage.verifyCartPageIsDisplayed();
    }

    @Step("Proceed to checkout")
    public void proceedToCheckout() {
        cartPage.proceedCheckout();
    }

    @Step("Fill the form")
    public void fillForm() throws InterruptedException {
        cartPage.fillForm();
    }
}
