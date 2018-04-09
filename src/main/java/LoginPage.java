import hu.selenium.FacebookLogin;
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

    @FindBy(css = "a[class='facebook-login social-login']")
    private WebElement facebookLoginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

    public void loginViaFacebook(String email, String password, WebDriver driver){
        facebookLoginButton.click();
        FacebookLogin.popUpLogin(email,password,driver);
    }
}
