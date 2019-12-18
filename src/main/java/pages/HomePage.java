package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class HomePage {
    private WebDriver driver;
    private By mainLoginButton = By.xpath("//a[@data-bx='top-nav-account-login']");
    private By usernameField = By.id("email");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//button[contains(text(),'LOG IN')]");
    private By loginStatus = By.xpath("//a[@aria-label='Account']");
    private By categoriesButton = By.xpath("//a[@title='Categories' and contains(span,'Categories')]");
    private By snacksButton = By.xpath("//a[@title='Snacks' and contains(span,'Snacks')]");
    private By cookiesButton = By.xpath("//a[@title='Cookies' and contains(span,'Cookies')]");
    private By groceryButton = By.xpath("//a[@title='Grocery' and contains(span,'Grocery')]");
    private By shopAllGroceryButton = By.xpath("//a[@title='Grocery' and contains(text(),'Shop All Grocery')]");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    private void clickLink(By linkText){
        driver.findElement(linkText).click();
    }

    public void setUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys((password));
    }

    public void clickLoginButton(){
        //wait.until(ExpectedConditions.visibilityOfElementLocated(mainLoginButton));
        driver.findElement(mainLoginButton).click();
    }

    public void switchToLoginWindow(){
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            driver.switchTo().window(window);
        }
    }

    public void clickModalLoginButton(){
       driver.findElement(loginButton).click();
    }

    public String getLoginStatus(){
        return driver.findElement(loginStatus).getText();
    }

    public void waitLogin(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(loginStatus));
    }

    //Cookies methods
    public void clickCategoriesButton(){
        WebElement category = driver.findElement(categoriesButton);
        WebElement snack = driver.findElement(snacksButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(category).perform();
        actions.moveToElement(snack).perform();
        
    }
    public CookiesPage clickCookiesPage(){
        driver.findElement(cookiesButton).click();
        return new CookiesPage(driver);
    }

    //Grocery methods
    public void moveToGroceryCategory(){
        WebElement category = driver.findElement(categoriesButton);
        WebElement grocery = driver.findElement(groceryButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(category).perform();
        actions.moveToElement(grocery).perform();

    }

    public GroceryPage clickGroceryPage(){
        driver.findElement(shopAllGroceryButton).click();
        return new GroceryPage(driver);
    }




}
