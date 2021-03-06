package pageObject;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.Map;

/**
 * Created by Nikolaj on 12.09.2017.
 */
public class ProviderPage extends BasePage {
    public ProviderPage(WebDriver driver) {
        super(driver);
    }

    By secondTabLocator = By.xpath("//span[contains(text(), 'Оплатить ЖКУ в Москве')]");
    By codeLocator = By.xpath("//*[@id=\"payerCode\"]");
    By errorCodeLocator = By.xpath("//form/div[1]/div/div[2]");
    By periodLocator = By.xpath("//input[@name=\"provider-period\"]");
    By errorPeriodLocator = By.xpath("//form/div[2]/div/div[2]");
    By paymentSummLocator = By.xpath("//div/div/div/div/div/div/label/div[1]/input");
    By errorPaymentSummLocator = By.xpath("//div[4]//div/div/div/div[2]");
    By bannerLocator = By.xpath("//h1");

    public void clickSecondTab() {
        click(secondTabLocator);
    }


    public void checkFieldCode(Map<String, String> testData){
        checkField(codeLocator, errorCodeLocator, testData);
    }

    public void checkFieldPeriod(Map<String, String> testData){
        checkField(periodLocator, errorPeriodLocator, testData);
    }

    public void checkFieldSumm(Map<String, String> testData) {
        checkField(paymentSummLocator, errorPaymentSummLocator, testData);
    }

    public String getBannerText(){
        String bannerText = getText(bannerLocator);
        return bannerText;
    }
}
