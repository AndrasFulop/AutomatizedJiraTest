package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class EnvironmentManager {
    protected static WebDriver driver;
    protected static String driverPath = System.getenv("driverPath");
    protected static DesiredCapabilities capability;

    protected static void setDriver(DesiredCapabilities capability,String nodeUrl){
        try {
            driver = new RemoteWebDriver(new URL(nodeUrl), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void shutDownDriver() {
        if(driver!=null) {
            System.out.println("Closing browser");
            RunEnvironment.getWebDriver().quit();
        }

    }
}
