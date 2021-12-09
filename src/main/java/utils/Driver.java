package utils;

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
        //chromeOptions.addArguments("headless");
        chromeOptions.addArguments("--no-sandbox");
        caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        if (System.getenv("SELENIUM_GRID").equals("true")) {
            webDriver = new RemoteWebDriver(new URL("http://10.100.3.167:4444/wd/hub"), caps);
        } else {
            webDriver = DriverFactory.getDriver();
        }
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


}
