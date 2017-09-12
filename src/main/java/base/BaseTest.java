package base;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Nikolaj on 10.09.2017.
 */
public class BaseTest {

    protected WebDriver wd;
    private String baseUrl;

    @BeforeClass
    public static void setupClass() {
        ChromeDriverManager.getInstance().setup();
    }

    @Before
    public void setUp() throws Exception {
        wd = new ChromeDriver();
        baseUrl = "https://www.tinkoff.ru/";
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.get(baseUrl);
    }

    @After
    public void shutDown(){
        wd.quit();
    }
}
