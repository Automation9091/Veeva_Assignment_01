package applications.cp;

import commonLibrary.basePage;
import commonLibrary.browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class shopMensPage extends basePage {

    public shopMensPage(WebDriver driver){
        PageFactory.initElements(browser.driver, this);
    }

    @FindBy(xpath = "//div[@class='left-container']//img[@alt='Golden State Warriors Official Online Shop']")
    private WebElement Img_WarriorShop;

    @FindBy(xpath = "(//span[text()='Men'])[1]")
    private WebElement Lbl_Men;

    @FindAll(
            @FindBy(xpath = "//img[@class=\"product-image\"]")
    )
    private List<WebElement> Img_Products;
}
