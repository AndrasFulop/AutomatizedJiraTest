package util;

import org.apache.commons.exec.OS;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

    /**
     * Environment variables
     * driverPath
     * username
     * password
     * myDriver
     */
    public static void setup() {
        if (System.getenv("myDriver").equals("chrome")){
                System.out.println("3*******************");
                System.out.println("Launching chrome browser");
                EnvironmentManager.initChromeRemoteWebDriver();

        } else {
                System.out.println("4*******************");
                System.out.println("Launching firefox browser");
                EnvironmentManager.initFireFoxRemoteWebDriver();

        }
    }

    public  static void tearDown() {
        if (OS.isFamilyMac()) {
            EnvironmentManagerMac.shutDownDriver();
        } else {
            EnvironmentManagerWin.shutDownDriver();
        }
    }

    /**
     * If an alert appears, it accepts.
     * @param driver
     */
    public static void acceptAlert(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            //exception handling
        }
    }

    /**
     * Highlights the webelement
     * @param webElement
     * @param webDriver
     */
    public static void highlighter(WebElement webElement, WebDriver webDriver) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red; border-color: red;');", webElement);
    }
}
