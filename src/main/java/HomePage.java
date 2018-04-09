import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(className = "logo")
    private WebElement logo;

    @FindBy(className = "slider-image")
    private WebElement slider;

    @FindBy(id = "header-left-option-2")
    private WebElement logInOutButton;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void clickOnLogInOutButton(){
        logInOutButton.click();
    }
}
