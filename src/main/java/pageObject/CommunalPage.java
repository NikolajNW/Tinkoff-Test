package pageObject;

import base.BasePage;
import testData.RegionEnums;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Nikolaj on 11.09.2017.
 */
public class CommunalPage extends BasePage {
    public CommunalPage(WebDriver driver) {
        super(driver);
    }

    By regionLocator = By.xpath("//div[text()='Коммунальные платежи']/span[2]");
    By searchRegionLocator = By.xpath("//div[contains(@class, 'ui-input__column')]/input[1]");
    By firstSearchResultLocator = By.xpath("/html/body/div[1]/div/div[2]/div[3]/div[2]/div/div/div/div[2]/div/div/span");
    By FirstElement = By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[1]/div[2]/div/div/div/div/span/section/ul/li[1]/span[2]/a");

    /** Проверяем регион, если не соответствует меняем*/
    public void checkRegion(RegionEnums region){
        String actualRegion = getText(regionLocator);
        if (!region.region1.equals(actualRegion)){
            click(regionLocator);
            setValue(searchRegionLocator, region.region2);
            click(firstSearchResultLocator);
        }
        }

    public String getNameFirstProvider(){
        return getText(FirstElement);
    }

    public ProviderPage clickFirstProvider(){
        click(FirstElement);
        return (new ProviderPage(wd));
    }
}

