package utils;

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {//Setting up capabilities to run our test script
    public static RemoteWebDriver webDriver;

    @BeforeSuite
    public void setUp() throws Exception {
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("window-size=1920,1080");
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("disable-notifications");
        chromeOptions.addArguments("process-per-site");
        chromeOptions.addArguments("--dns-prefetch-disable");
        chromeOptions.addArguments("--no-sandbox");
        caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        webDriver = DriverFactory.getDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDown(){
        webDriver.quit();
    }

}
