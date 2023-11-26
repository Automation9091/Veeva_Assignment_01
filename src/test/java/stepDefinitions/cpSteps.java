package stepDefinitions;

import applications.cp.shopMensPage;
import commonLibrary.browser;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class cpSteps extends browser {
    commonSteps cs;
    HashMap<Object, String> prodInfo;
    shopMensPage spMain;
    @Then("I pull out all products from the selected page")
    public void getAllProducts() throws InterruptedException {


        prodInfo = new HashMap<Object, String>();
        try{
            int cnt = 0;
            WebElement eleNext = browser.driver.findElement(By.xpath("//div[@class='paginator']//i[@aria-label='next page']"));
            List<WebElement> lstPrice;
            List<WebElement> lstProd;
            while (eleNext.getAttribute("aria-disabled").equals("false")){
                lstProd = browser.driver.findElements(By.xpath("//div[@class='product-card row']//img[@class='product-image']"));
                lstPrice = browser.driver.findElements(By.xpath("//div[@class='product-card row']//span[@class='lowest']//span[@class='sr-only']"));

                for (int iSt = 0; iSt < lstProd.size(); iSt++){
                    cnt = cnt + 1;
                    //logger.info("Product name is: " + ele.getAttribute("alt"));
                    prodInfo.put("Product " + cnt, "Product Name: " +
                            lstProd.get(iSt).getAttribute("alt") + " Price: " + lstPrice.get(iSt).getText());

                }

                Thread.sleep(1500);
                eleNext.click();
                Thread.sleep(2500);
                eleNext = browser.driver.findElement(By.xpath("//div[@class='paginator']//i[@aria-label='next page']"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Then("I create a text file and add product details to it")
    public void createTextAndAddProd() throws FileNotFoundException, UnsupportedEncodingException {
        String filePath = System.getProperty("user.dir") + "/test-output/prodFile.txt";
        PrintWriter writer = new PrintWriter(filePath, "UTF-8");

        Set keys = prodInfo.keySet();

        for (Object key : keys){
            writer.println((key + ": " + prodInfo.get(key)));
        }
        writer.close();

    }
}
