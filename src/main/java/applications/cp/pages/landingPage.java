package applications.cp.pages;

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

    @FindBy(xpath = "//li[@class='menu-item']//span[text()='Shop']")
    private WebElement Btn_Shop;

    @FindBy(xpath = "(//nav[@aria-label='submenu']//a[@title=\"Men's\"])[1]")
    private WebElement Btn_Mens;

    @FindBy(xpath = "//div[text()='x']")
    private WebElement Btn_Close;

    @FindBy(xpath = "//li[@class='menu-item']//span[text()='...']")
    private WebElement Btn_ThreeDots;

    @FindBy(xpath = "(//a[@href='/warriors/news'])[1]")
    private WebElement Lnk_NewsAndFeatures;
}