package stepDefinitions;

import applications.cp.homePage;
import applications.cp.landingPage;
import applications.cp.shopMensPage;
import com.esotericsoftware.yamlbeans.YamlException;
import commonLibrary.basePage;
import commonLibrary.browser;
import commonLibrary.utility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.time.Duration;

public class commonSteps extends browser {
    static String applicationName = null;
    browser brw = new browser();
    landingPage cpLp;

    WebDriverWait eWait;

    WebDriver driver;

    basePage page;
    utility ut = new utility();

    public WebElement waitForElement(WebElement element){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(browser.driver)
                .withTimeout(Duration.ofSeconds(60L))
                .pollingEvery(Duration.ofSeconds(5L))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOf(element));

        return element;
    }

    @When("^I launch the (.*) browser$")
    public void browserSetup(String brwName){
        logger.info("***** Executing browserSetup method *****");
        brw.launchBrowser(brwName);
        logger.info("Browser launched");
        eWait = new WebDriverWait(browser.driver, Duration.ofSeconds(45));
    }

    @And("^I switch the browser tab to child$")
    public void switchTab(){
        String originalWindow = browser.driver.getWindowHandle();
        String childWindowHandle = null;
        for (String wndHandle: browser.driver.getWindowHandles()){
            if (!wndHandle.equals(originalWindow)){
                logger.info("Child Window Handle: " + wndHandle);
                childWindowHandle = wndHandle;
                break;
            }
        }
        browser.driver.switchTo().window(childWindowHandle);

    }

    @And("^I click (.*) element if exists$")
    public void clickElementStepIfExist(String eleName) throws InterruptedException {
        WebElement ele = getElement(eleName);
        try{
            if (waitForElement(ele).isDisplayed()){
                waitForElement(ele).click();
            }
        }catch(Exception e){
            logger.info("Error Message: "+ e.getMessage());
        }


        /*WebElement eleToBeClicked = eWait.until(ExpectedConditions.elementToBeClickable(ele));
        eleToBeClicked.click();*/
        /*for (int i = 1; i < 5; i++){
            if (checkElementExists(ele).equals("ElementNotFound")){
                logger.info(eleName + " element not identified!");
                Thread.sleep(5000);
            }else{
                ele.click();
                logger.info(eleName + " element clicked!");
                break;
            }
        }*/
    }

    @And("^I click (.*) element$")
    public void clickElementStep(String eleName) throws InterruptedException {
        WebElement ele = getElement(eleName);
        waitForElement(ele);
        checkElementExists(ele, "click").click();
        /*WebElement eleToBeClicked = eWait.until(ExpectedConditions.elementToBeClickable(ele));
        eleToBeClicked.click();*/
        /*for (int i = 1; i < 5; i++){
            if (checkElementExists(ele).equals("ElementNotFound")){
                logger.info(eleName + " element not identified!");
                Thread.sleep(5000);
            }else{
                ele.click();
                logger.info(eleName + " element clicked!");
                break;
            }
        }*/
    }

    @Then("^I open the (.*) application in (.*) environment$")
    public void openApplication(String appName, String envName) throws YamlException, FileNotFoundException {
        applicationName = appName;
        String url = ut.getValueFromYml(envName, appName, "URL");
        brw.openApp(url);
        logger.info(url + " opened!");
    }

    @Given("^I am on (.*) page$")
    public void setPage(String pageName){
        page = getPage(pageName);
        logger.info(pageName + " loaded!");
    }

    @And("^I verify (.*) element is displayed$")
    public void verifyEleDisplayed(String eleName) throws InterruptedException {
        WebElement ele = getElement(eleName);
        checkElementExists(ele, "sendkeys");
        /*for (int i = 1; i < 10; i++){
            if (checkElementExists(ele).equals("ElementNotFound") ){
                Thread.sleep(5000);
            }else{
                ele.isDisplayed();
                logger.info(ele + " is verified!");
                break;
            }
        }*/
    }

    @And("^I mouse hover the (.*) element$")
    public void mouseHoverElement(String eleName) throws InterruptedException {
        Thread.sleep(2500);
        WebElement element = getElement(eleName);

        Actions action = new Actions(browser.driver);
        action.moveToElement(element).build().perform();

        Thread.sleep(2500);

    }

    @And("^I wait for (.*) seconds$")
    public void hardCodeWait(int val) {
        try {
            Thread.sleep(val * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



    public WebElement getElement(String elementName) {
        WebElement ele = null;
        try {
            Field field = page.getClass().getDeclaredField(elementName);
            field.setAccessible(true);
            return (WebElement) field.get(page);
        } catch (NoSuchElementException el) {
            el.getMessage();
        } catch (NullPointerException np) {
            np.getMessage();
        } catch (SecurityException | NoSuchFieldException | IllegalAccessException s) {
            s.getMessage();
        }

        return ele;
    }

    public WebElement checkElementExists(WebElement ele, String action) throws InterruptedException {
        String message = "";
        WebElement eleToSearch = null;
        for (int i=0; i < 2; i++){
            try{
                switch (action.toLowerCase()){
                    case "click":
                        eleToSearch = eWait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(ele)));
                        break;
                    case "sendkeys":
                        eleToSearch = eWait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(ele)));
                        break;
                }

            }catch(NoSuchElementException | StaleElementReferenceException st){
                //System.out.println("Error Message: " + st.getMessage());
                logger.info("Error Message: " + st.getMessage());
                message = st.getMessage();
            }

            if (message.length() > 0){
                Thread.sleep(2500);
            }else{
                break;
            }
        }

        return eleToSearch;
    }

    public basePage getPage(String pageName){
        basePage page = null;

        switch (applicationName.toLowerCase()) {
            case "cp":
                switch (pageName.toLowerCase()) {
                    case "landing":
                        page = new landingPage(browser.driver);
                        break;
                    case "homepage":
                        page = new homePage(browser.driver);
                        break;
                    case "shopmens":
                        page = new shopMensPage(browser.driver);
                        break;
                }
                break;
            case "dp1":
                switch (pageName.toLowerCase()) {
                    case "landing":
                        page = new applications.dp1.landingPage(browser.driver);
                        break;
                }
                break;
            case "dp2":
                switch (pageName.toLowerCase()) {
                    case "landing":
                        page = new applications.dp2.landingPage(browser.driver);
                        break;
                }
                break;
        }
        return page;
    }

}
