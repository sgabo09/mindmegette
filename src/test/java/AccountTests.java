import hu.selenium.BrowserManager;
import hu.selenium.BrowserType;
import hu.selenium.TestTracer;
import hu.selenium.UserManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountTests {
    static WebDriver driver = BrowserManager.getBrowser(BrowserType.FIREFOX);
    static HomePage homePage = new HomePage(driver);
    static LoginPage loginPage = new LoginPage(driver);
    static AccountPage accountPage = new AccountPage(driver);
    static UserManager userManager = new UserManager();

    @Rule
    public TestTracer testTracer = new TestTracer(driver);

    @BeforeClass
    public static void setUp(){
        driver.get("http://mindmegette.hu/adatmodositas");
        loginPage.login(userManager.getUserEmail("default"),userManager.getUserPassword("default"));
    }

    @Test
    public void changeProfileImage(){
        accountPage.editProfileImage("D:\\MIK\\Szakdolgozat\\Project\\eatingkid.jpg");
    }

    @Test
    public void deleteProfileImage(){
        accountPage.deleteProfileImage();
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
