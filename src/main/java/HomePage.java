import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class HomePage extends AbstractPage {

    @FindBy(className = "logo")
    private WebElement logo;

    @FindBy(className = "slider-image")
    private WebElement slider;

    @FindBy(id = "header-left-option-2")
    private WebElement logInOutButton;

    @FindBy(xpath = "//*[@id=\"sticky_nav\"]/ul/li[1]/a")
    private WebElement recipeButton;

    @FindBy(xpath = "//*[@id='sticky_nav']/ul/li[1]/ul/li/a")
    private List<WebElement> recipes;

    @FindBy(xpath = "//*[@id=\"sticky_nav\"]/ul/li[2]/a")
    private WebElement magazineButton;

    @FindBy(xpath = "//*[@id='sticky_nav']/ul/li[2]/ul/li/a")
    private List<WebElement> magazines;

    @FindBy(xpath = "//*[@id=\"sticky_nav\"]/ul/li[3]/a")
    private WebElement dietsButton;

    @FindBy(xpath = "//*[@id=\"sticky_nav\"]/ul/li[4]/a")
    private WebElement foodTestsButton;


    Random random = new Random();

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void clickOnLogInOutButton(){
        logInOutButton.click();
    }

    public void navigateToRandomRecipePage(){
        int id = random.nextInt(recipes.size());
        Actions builder = new Actions(driver);
        builder.moveToElement(recipeButton).build().perform();
        recipes.get(id).click();
        Assert.assertEquals(recipes.get(id).getAttribute("href") + "/",driver.getCurrentUrl());
    }

    public void navigateToRandomMagazinePage(){
        int id = random.nextInt(magazines.size());
        Actions builder = new Actions(driver);
        builder.moveToElement(magazineButton).build().perform();
        magazines.get(id).click();
        Assert.assertEquals(magazines.get(id).getAttribute("href") + "/",driver.getCurrentUrl());
    }

    public void navigateToDietsPage(){
        dietsButton.click();
        Assert.assertEquals(dietsButton.getAttribute("href"),driver.getCurrentUrl());
    }

    public void navigateToFoodTestsPage(){
        foodTestsButton.click();
        Assert.assertEquals(foodTestsButton.getAttribute("href"),driver.getCurrentUrl());
    }
}
