package base;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

/**
 * Created by Nikolaj on 10.09.2017.
 */
public class BasePage {

    protected WebDriver wd;
    private WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.wd = driver;
        wait = new WebDriverWait(wd,10);
    }

    protected void click(By locator){
        /**Боримся с непонятными падениями*/
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        wd.findElement(locator).click();
    }

    protected void setValue(By locator, String Value){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(Value);
    }

    protected String getText(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        String result =  wd.findElement(locator).getText();

        return result;
    }

    /** Param Map.Key: test data
     * Param: Map.Value: error message
     * return Assert result*/
    protected void checkField(By field, By errorMesage, Map<String, String> testData){
        for (Map.Entry<String, String> data : testData.entrySet()) {
            setValue(field, data.getKey());
            wd.findElement(field).sendKeys(Keys.ENTER);
            Assert.assertEquals(data.getValue(), getText(errorMesage));
        }
    }
}
