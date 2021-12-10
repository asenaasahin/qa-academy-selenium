package steps;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class HomePageSteps {
    private HomePage homepage = new HomePage();

    @Step("Verify homepage is displayed")
    public void verifyHomePage(){
        homepage.verifyHomePage();
    }
}
