package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CheckoutPage {
    private WebDriver driver;
    private By shippingCost = By.xpath("//div[@data-bx='order-pricing-list']");
    private By orderItems = By.xpath("//h3[text()='YOUR BOXED ORDER']");
    private List<String> prodList= new ArrayList<>();
    private By product_name= By.className("g-brand-text");

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    public Boolean isFreeShipping(){
        System.out.println(driver.findElement(shippingCost).getText());

        if (driver.findElement(shippingCost).getText().contains("FREE")){
            return true;
        }
        else{
            return false;
        }
    }

    public List<String> getProductList(){
        WebElement products = driver.findElement(orderItems);
        List<WebElement> list = products.findElements(By.tagName("li"));

        for (int i = 0; i < list.size(); i++)
        {
            prodList.add(list.get(i).findElement(product_name).getText());
            System.out.println(list.get(i).findElement(product_name).getText());
        }
        return prodList;
    }

    public Boolean compareAddedProductsWithCheckout(List<String> l1, List<String> l2){

        if (l1.containsAll(l2)){
            return true;
        }
        else {
            return false;
        }
    }


}
