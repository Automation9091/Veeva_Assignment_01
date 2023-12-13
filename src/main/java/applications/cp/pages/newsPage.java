package applications.cp.pages;

import commonLibrary.basePage;
import commonLibrary.browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class newsPage extends basePage {

    public newsPage(WebDriver driver){
        PageFactory.initElements(browser.driver, this);
    }

    @FindBy(xpath = "//h3[text()='VIDEOS']//parent::div//following-sibling::div")
    private WebElement Section_Videos;

    @FindBy(xpath = "//h3[text()='NEWS']")
    private WebElement Lbl_News;
}
