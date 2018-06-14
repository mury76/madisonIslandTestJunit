package org.fasttrackit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static WebDriver driver;

    public static void initDriver() {
        // Reading parameter provided from command line
        // For example: mvn test -Dtest="testname" -Dbrowser=firefox

        String browser = System.getProperty("browser", "chrome");

        switch (browser) {
            default:
                System.out.println("Using default browser: Chrome");
            case "chrome":
                System.setProperty("webdriver.chrome.driver",
                        "C:\\Users\\mury7\\FastTrackIt\\nadisonIslandTest\\src\\test\\resources\\drivers\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver",
                        "C:\\Users\\mury7\\FastTrackIt\\madisonIslandTestJunit\\src\\test\\resources\\drivers\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver",
                        "C:\\Users\\mury7\\FastTrackIt\\madisonIslandTestJunit\\src\\test\\resources\\drivers\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                break;
            case "opera":
                System.setProperty("webdriver.opera.driver",
                        "C:\\Users\\mury7\\FastTrackIt\\madisonIslandTestJunit\\src\\test\\resources\\drivers\\operadriver.exe");
                driver = new OperaDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver",
                        "C:\\Users\\mury7\\FastTrackIt\\madisonIslandTestJunit\\src\\test\\resources\\drivers\\MicrosoftWebDriver.exe");
                driver = new EdgeDriver();
                break;
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        DriverFactory.getDriver().get("https://fasttrackit.org/selenium-test/");
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
