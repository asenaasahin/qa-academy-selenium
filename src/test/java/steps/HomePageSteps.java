package steps;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class HomePageSteps {
    HomePage homepage = new HomePage();

    @Step("Verify homepage is displayed")
    public void verifyHomePage() {
        homepage.verifyHomePage();
    }

    @Step("Shop Now button is clicked")
    public void goToShopNow() {
        homepage.goToShopNow();
    }

    @Step("Check the elements which are displayed on the below")
    public void checkBelowElement() {
        homepage.scrollDown();
        homepage.verifyContactInfo();
    }

    @Step("Back to top of the page")
    public void backToTop() throws InterruptedException {
        homepage.backToTop();
    }

    @Step("Go to Shop Page")
    public void goToShop() {
        homepage.clickOnNavigationShopButton();
    }
}
