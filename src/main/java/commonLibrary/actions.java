package commonLibrary;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class actions {
    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45000));
    public void clickElement(WebElement element){
        try{
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        }catch(StaleElementReferenceException ec){
            System.out.println("Exception occurred when executing clickElement method for element: " + element + " ****" + ec.getMessage() + " ****");
        }finally {

        }

    }

    public boolean checkElementExistence(WebElement element){
        boolean ret = false;
        try{
            ret = wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        }catch(StaleElementReferenceException st){
            System.out.println("Exception occurred when executing checkElementExistence method for element: " + element + " ****" + st.getMessage() + " ****");
        }finally{

        }
        return ret;
    }

    public void enterTextInTextBox(WebElement element){
        try{
            wait.until(ExpectedConditions.visibilityOf(element));
        }catch(StaleElementReferenceException st){
            System.out.println("Exception occurred when executing enterTextInTextBox method for element: " + element + " ****" + st.getMessage() + " ****");
        }finally{

        }
    }
}
