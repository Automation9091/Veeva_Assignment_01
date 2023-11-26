package applications.dp1;

import commonLibrary.basePage;
import commonLibrary.browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landingPage extends basePage {

    public landingPage(WebDriver driver){
        PageFactory.initElements(browser.driver, this);
    }

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement Btn_AcceptCookies;

    @FindBy(xpath = "//img[@alt='NBA Logo']")
    private WebElement Img_NbaLogo;
}
