import hu.selenium.BrowserManager;
import hu.selenium.BrowserType;
import hu.selenium.TestTracer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class PortalTests{

    static WebDriver driver = BrowserManager.getBrowser(BrowserType.CHROME);
    HomePage homePage = new HomePage(driver);

    @Rule
    public TestTracer testTracer = new TestTracer(driver);

    @BeforeClass
    public static void setUp(){
        driver.get("http://mindmegette.hu");
    }

    @Test
    public void portalAvailability(){
        homePage.navigateToRandomRecipePage();
        homePage.navigateToRandomMagazinePage();
        homePage.navigateToDietsPage();
        homePage.navigateToFoodTestsPage();
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
