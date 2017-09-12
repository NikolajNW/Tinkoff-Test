package pageObject;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Nikolaj on 10.09.2017.
 */
public class TopMenu extends BasePage {

    public TopMenu(WebDriver driver) {
        super(driver);
    }

    By payments = By.xpath("//*[@id=\"mainMenu\"]/li[3]/span/a/span");

    public PaymentsPage goToPaymentsPage(){
        click(payments);
        return (new PaymentsPage(wd));
    }
}
