import hu.selenium.FileUploadManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends AbstractPage {

    @FindBy(css = "a[class='button button-green with-icon edit']")
    private WebElement editProfileButton;

    @FindBy(css = "span[class='add dz-clickable']")
    private WebElement uploadPictureButton;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void editProfile(String filePath){
        editProfileButton.click();
        uploadPictureButton.click();
        FileUploadManager.fileUploadWindow(filePath);
    }
}
