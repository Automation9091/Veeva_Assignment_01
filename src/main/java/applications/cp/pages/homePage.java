package applications.cp.pages;

import commonLibrary.basePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class homePage extends basePage {


    public homePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
