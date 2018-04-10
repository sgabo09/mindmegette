import hu.selenium.BrowserManager;
import hu.selenium.BrowserType;
import hu.selenium.TestTracer;
import hu.selenium.UserManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginTests {
    static WebDriver driver = BrowserManager.getBrowser(BrowserType.CHROME);
    UserManager userManager = new UserManager();
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);

    @Rule
    public TestTracer testTracer = new TestTracer(driver);

    @BeforeClass
    public static void setUp(){
        driver.get("http://mindmegette.hu");
        driver.findElement(By.cssSelector("span[class='button button-green medium i-agree']")).click();
    }

    @Test
    public void login(){
        homePage.clickOnLogInOutButton();
        loginPage.login(userManager.getUserEmail("default"),userManager.getUserPassword("default"));
        homePage.clickOnLogInOutButton();
    }

    @Test
    public void facebookLogin(){
        homePage.clickOnLogInOutButton();
        loginPage.loginViaFacebook(userManager.getUserEmail("facebook"),userManager.getUserPassword("facebook"),driver);
        homePage.clickOnLogInOutButton();
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}
