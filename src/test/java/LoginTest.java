import hu.selenium.BrowserManager;
import hu.selenium.BrowserType;
import hu.selenium.TestTracer;
import hu.selenium.UserManager;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginTest {
    WebDriver driver = BrowserManager.getBrowser(BrowserType.FIREFOX);
    UserManager userManager = new UserManager();
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);

    @Rule
    public TestTracer testTracer = new TestTracer(driver);

    @Before
    public void setUp(){
        driver.get("http://mindmegette.hu");
        driver.findElement(By.cssSelector("span[class='button button-green medium i-agree']")).click();
    }

    @Test
    public void login(){
        homePage.clickOnLoginButton();
        loginPage.logIn(userManager.getUserEmail("default"),userManager.getUserPassword("default"));
    }
}
