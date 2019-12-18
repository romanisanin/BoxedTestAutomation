package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;


public class FavoritesPage {
    private WebDriver driver;
    private By title = By.xpath("//h1[contains(span,'Favorites')]");
    private By product_name= By.className("g-brand-text");
    private List<String> favList= new ArrayList<>();

    public FavoritesPage(WebDriver driver){
        this.driver = driver;
    }

    public List<String> getFavoritesList(){
        WebElement li_List = driver.findElement(By.cssSelector("#account-add-favorites > .g-product-list"));
        List<WebElement> favListWE = li_List.findElements(By.tagName("li"));
        for (int i = 0; i < 2; i++)
        {
            String product = favListWE.get(i).findElement(product_name).getText();
            System.out.println(product);
            favList.add(product);
        }
        return favList;
    }

    public Boolean CompareExistFavWithAdded(List<String> ExistFav, List<String> AddedFav){
        List<String> l1 = ExistFav;
        List<String> l2 = AddedFav;

        if (l1.containsAll(l2)){
            return true;
        }
        else {
            return false;
        }
    }
}
