package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class GroceryPage {
    private WebDriver driver;
    public List<String> prodList= new ArrayList<>();
    private By product_name= By.className("g-brand-text");

    public GroceryPage(WebDriver driver){
        this.driver = driver;
    }

    public void waitForLoad() {
        ExpectedCondition<Boolean> pageLoadCondition = driver -> ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }

    public void AddUntilFreeShipping() throws InterruptedException{
        WebElement products = driver.findElement(By.className("g-product-list"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        List<WebElement> list = products.findElements(By.tagName("li"));
        for (int i = 0; i < list.size(); i++)
        {
            Boolean isPresented = driver.findElements(By.xpath("//span[text()='Your order ships FREE!']")).size() > 0;
            System.out.println(isPresented);
            if(isPresented){
                break;
            }
            list.get(i).findElement(By.cssSelector("button[aria-label='Add']")).click();
            prodList.add(list.get(i).findElement(product_name).getText());
            System.out.println(list.get(i).findElement(product_name).getText());

        }
    }

    public CheckoutPage clickCheckoutButton(){
        driver.findElement(By.xpath("//button[contains(text(),'CHECKOUT')]")).click();
        return new CheckoutPage(driver);
    }
}
