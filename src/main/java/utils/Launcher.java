package utils;

import com.thoughtworks.gauge.Step;

import java.util.concurrent.TimeUnit;

public class Launcher {
    public static String APP_URL = "https://training.qastorming.com";

    @Step("Go to the home page")
    public void launchThePage() {
        Driver.webDriver.get(APP_URL);
        Driver.webDriver.manage().window().maximize();
        Driver.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
