package pageObject;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Nikolaj on 11.09.2017.
 */
public class PaymentsPage extends BasePage {
    public PaymentsPage(WebDriver driver) {
        super(driver);
    }

    By communalPage = By.xpath("//*[text()='Коммунальные платежи']");
    By searchField = By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[1]/div[2]/div/div[1]/div[2]/div/div/div/label/input");
    By firstElementSearchResult = By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[1]/div[2]/div/div[1]/div[2]/div/div[2]/div/div[1]/div/div[1]/div/div[1]/div[1]");

    public CommunalPage goToCommunalPage() {
        click(communalPage);
        return (new CommunalPage(wd));
    }

    public BasePage clickSearchResult(String text) {
        setValue(searchField, text);
        click(firstElementSearchResult);
        if (text.equals("ЖКУ-Москва")) {
            return (new ProviderPage(wd));
        }
        return null;
    }
}
