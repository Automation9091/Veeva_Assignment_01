package commonLibrary;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class browser {
    public static Logger logger = log.getLogData(log.class.getName());
    public static WebDriver driver;
    public WebDriver launchBrowser(String brwName){
        switch (brwName){
            case "Chrome" : case "chrome" :
                driver = new ChromeDriver();
                break;
            case "Firefox" : case "firefox" :
                driver = new FirefoxDriver();
                break;
            case "Edge" : case "edge" :
                driver = new EdgeDriver();
                break;
        }
        //driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(1200, 900));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        return driver;
    }

    public void openApp(String url){
        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90000));

    }

    public void closeBrowser(){
        driver.quit();
    }
}
