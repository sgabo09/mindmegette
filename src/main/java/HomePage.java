import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
    @FindBy(className = "slider-image")
    private WebElement slider;

    @FindBy(id = "header-left-option-2")
    private WebElement loginButton;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }

}
