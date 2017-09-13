import base.BaseTest;
import org.junit.*;
import pageObject.CommunalPage;
import pageObject.TopMenu;
import pageObject.PaymentsPage;
import pageObject.ProviderPage;

import java.util.HashMap;
import java.util.Map;

import static enums.RegionEnums.MSK;
import static enums.RegionEnums.SPB;

/**
 * Created by Nikolaj on 09.09.2017.
 */
public class TinkoffTest extends BaseTest{

    TopMenu topMenu;
    PaymentsPage paymentsPage;
    CommunalPage communalPage;
    ProviderPage providerPage;

    private static final Map<String, String> CODE;
    static {
        CODE = new HashMap<String, String>();
        CODE.put(" ", "Поле обязательное");
        CODE.put("1", "Поле неправильно заполнено");
        CODE.put("111111111", "Поле неправильно заполнено");
    }

    private static final Map<String, String> PERIOD;
    static {
        PERIOD = new HashMap<String, String>();
        PERIOD.put("", "Поле обязательное");
        PERIOD.put("01", "Поле заполнено некорректно");
        PERIOD.put("13.2017", "Поле заполнено некорректно");
        PERIOD.put("00.2017", "Поле заполнено некорректно");
    }

    private static final Map<String, String> SUMM;
    static {
        SUMM = new HashMap<String, String>();
        SUMM.put("", "Поле обязательное");
        SUMM.put("0", "Минимальная сумма перевода - 10 ₽");
        SUMM.put("9", "Минимальная сумма перевода - 10 ₽");
        SUMM.put("15001", "Максимальная сумма перевода - 15 000 ₽");
    }

    @Test
    public void tinkoffTest(){
        topMenu = new TopMenu(wd);
        paymentsPage = topMenu.goToPaymentsPage();

        communalPage = paymentsPage.goToCommunalPage();

        communalPage.checkRegion(MSK);
        String titleProvider = communalPage.getNameFirstProvider();
        providerPage = communalPage.clickFirstProvider();

        String bannerText = providerPage.getBannerText();
        providerPage.clickSecondTab();

        providerPage.checkFieldCode(CODE);
        providerPage.checkFieldPeriod(PERIOD);
        providerPage.checkFieldSumm(SUMM);

        topMenu = new TopMenu(wd);
        paymentsPage = topMenu.goToPaymentsPage();
        providerPage = (ProviderPage) paymentsPage.clickSearchResult(titleProvider);
        Assert.assertEquals(bannerText, providerPage.getBannerText());

        topMenu = new TopMenu(wd);
        paymentsPage = topMenu.goToPaymentsPage();
        communalPage = paymentsPage.goToCommunalPage();
        communalPage.checkRegion(SPB);

        Assert.assertNotEquals("ЖКУ-Москва", communalPage.getNameFirstProvider());
    }

}
