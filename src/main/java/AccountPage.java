import hu.selenium.FileUploadManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage extends AbstractPage {

    @FindBy(css = "a[class='button button-green with-icon edit']")
    private WebElement editProfileButton;

    @FindBy(css = "span[class='add dz-clickable']")
    private WebElement imageUploadButton;

    @FindBy(className = "delete")
    private WebElement deleteImageButton;

    @FindBy(css = "span[class='button button-green medium i-agree']")
    private WebElement cookieButton;

    @FindBy(id = "btnModifySubmit")
    private WebElement submitButton;

    private WebDriverWait wait = new WebDriverWait(driver,10);

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void editProfileImage(String filePath){
        editProfileButton.click();
        cookieButton.click();
        imageUploadButton.click();
        FileUploadManager.fileUploadWindow(filePath);
        wait.until(ExpectedConditions.invisibilityOf(cookieButton));
        submitButton.click();
    }

    public void deleteProfileImage(){
        editProfileButton.click();
        cookieButton.click();
        deleteImageButton.click();
        wait.until(ExpectedConditions.invisibilityOf(cookieButton));
        submitButton.click();
    }
}
