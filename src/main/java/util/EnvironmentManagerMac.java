package util;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class EnvironmentManagerMac extends EnvironmentManager {
    public static String nodeUrl = "http://192.168.160.66:4444/wd/hub";
    protected static WebDriver driver;
    protected static String driverPath = System.getenv("driverPath");
    protected static DesiredCapabilities capability;

    public static void initChromeWebDriver() {

        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", driverPath);

        RunEnvironment.setWebDriver(driver);
    }

    public static void initChromeRemoteWebDriver(){
        capability = DesiredCapabilities.chrome();
        capability.setBrowserName("chrome");
        try {
            driver = new RemoteWebDriver(new URL(nodeUrl), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        RunEnvironment.setWebDriver(driver);
    }

    public static void initFireFoxWebDriver() {
        System.setProperty("webdriver.gecko.driver", driverPath );
        driver = new FirefoxDriver();

        RunEnvironment.setWebDriver(driver);
    }

    public static void initFireFoxRemoteWebDriver() {
        capability = DesiredCapabilities.firefox();
        capability.setBrowserName("firefox");
        capability.setPlatform(Platform.WINDOWS);
        try {
            driver = new RemoteWebDriver(new URL(nodeUrl), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        RunEnvironment.setWebDriver(driver);
    }

    public static void shutDownDriver() {
        if(driver!=null) {
            System.out.println("Closing browser");
            RunEnvironment.getWebDriver().quit();
        }

    }

    protected static void setDriver(DesiredCapabilities capability,String nodeUrl){
        try {
            driver = new RemoteWebDriver(new URL(nodeUrl), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
