import hu.selenium.UserManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(id = "right-label")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "btnLoginSubmit")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void logIn(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        submitButton.click();
    }
}
