package base;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.CookiesPage;
import pages.FavoritesPage;
import pages.GroceryPage;

import javax.swing.*;

public class LoginTest extends baseTests {
    @Test
    public void testSuccessfulLogin() {
        homePage.clickLoginButton();
        //Thread.sleep(2000);
        homePage.switchToLoginWindow();
        homePage.setUsername("romanisanin@gmail.com");
        homePage.setPassword("Fcnhf461119");
        homePage.clickModalLoginButton();
        homePage.waitLogin();
        Assert.assertTrue(homePage.getLoginStatus().contains("Account"),
                "Login is incorrect");
    }

    @Test
    public void testAddFavoriteItems() throws InterruptedException{
        homePage.clickLoginButton();
        Thread.sleep(2000);
        homePage.switchToLoginWindow();
        homePage.setUsername("romanisanin@gmail.com");
        homePage.setPassword("Fcnhf461119");
        homePage.clickModalLoginButton();
        homePage.waitLogin();
        homePage.clickCategoriesButton();
        CookiesPage cookiesPage = homePage.clickCookiesPage();
        cookiesPage.waitForLoad();
        Thread.sleep(5000);
        cookiesPage.getCookiesList();
        FavoritesPage favoritesPage = cookiesPage.clickFavoritesLink();
        Assert.assertTrue(favoritesPage.CompareExistFavWithAdded(favoritesPage.getFavoritesList(), cookiesPage.AddedFav),
                "Favorites List doesn't contain elements added on Cookies Page");
    }

    @Test
    public void testFreeShipping() throws InterruptedException{
        homePage.clickLoginButton();
        Thread.sleep(2000);
        homePage.switchToLoginWindow();
        homePage.setUsername("romanisanin@gmail.com");
        homePage.setPassword("Fcnhf461119");
        homePage.clickModalLoginButton();
        homePage.waitLogin();
        homePage.moveToGroceryCategory();
        GroceryPage groceryPage = homePage.clickGroceryPage();
        groceryPage.waitForLoad();
        Thread.sleep(5000);
        groceryPage.AddUntilFreeShipping();
        CheckoutPage checkoutPage = groceryPage.clickCheckoutButton();
        Thread.sleep(5000);
        Assert.assertTrue(checkoutPage.isFreeShipping(), "The shipping price is not free");
        Assert.assertTrue(checkoutPage.compareAddedProductsWithCheckout(groceryPage.prodList, checkoutPage.getProductList()), "Order List doesn't contain elements added on Grocery Page");

    }
}
