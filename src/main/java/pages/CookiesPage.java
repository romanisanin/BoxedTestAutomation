package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class CookiesPage {
    private WebDriver driver;
    private By favoritesLink = By.xpath("//a[contains(text(),'Favorites')]");
    private By product_name= By.className("g-brand-text");
    public List<String> AddedFav = new ArrayList<>();

    public CookiesPage(WebDriver driver){
        this.driver = driver;
    }

    public void waitForElement() {
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            driver.switchTo().window(window);
        }
   }

    public void getCookiesList(){
        WebElement industries = driver.findElement(By.className("g-product-list"));
        List<WebElement> links = industries.findElements(By.tagName("li"));
        for (int i = 0; i < 2; i++)
        {
            links.get(i).findElement(By.cssSelector("a[aria-label='Add to Favorites']")).click();
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Close modal']")));
            waitForElement();
            el.click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@aria-label='Close modal']")));
            wait.until(ExpectedConditions.elementToBeClickable(By.id("top-nav-logo")));
            AddedFav.add(links.get(i).findElement(product_name).getText());
            System.out.println(links.get(i).findElement(product_name).getText());
        }

    }

    public FavoritesPage clickFavoritesLink(){
        driver.findElement(By.xpath("//*[@id=\"menu\" ] //a[@title='Favorites']")).click();
        return new FavoritesPage(driver);
    }
}
