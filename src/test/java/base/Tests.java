package base;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.CookiesPage;
import pages.FavoritesPage;
import pages.GroceryPage;

import javax.swing.*;

public class Tests extends baseTests {
    @Test(priority = 1)
    public void testSuccessfulLogin() throws InterruptedException {
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

    @Test(priority = 2)
    public void testAddFavoriteItems() throws InterruptedException{
        homePage.clickLoginButton();
        //Thread.sleep(2000);
        homePage.switchToLoginWindow();
        homePage.setUsername("romanisanin@gmail.com");
        homePage.setPassword("Fcnhf461119");
        homePage.clickModalLoginButton();
        homePage.waitLogin();
        homePage.moveToElement(homePage.categoriesButton);
        homePage.moveToElement(homePage.snacksButton);
        CookiesPage cookiesPage = homePage.clickCookiesPage();
        pageLoad();
        cookiesPage.getCookiesList();
        FavoritesPage favoritesPage = cookiesPage.clickFavoritesLink();
        Assert.assertTrue(favoritesPage.CompareExistFavWithAdded(favoritesPage.getFavoritesList(), cookiesPage.AddedFav),
                "Favorites List doesn't contain elements added on Cookies Page");
    }

    @Test (priority = 3)
    public void testFreeShipping() throws InterruptedException{
        homePage.clickLoginButton();
        Thread.sleep(2000);
        homePage.switchToLoginWindow();
        homePage.setUsername("romanisanin@gmail.com");
        homePage.setPassword("Fcnhf461119");
        homePage.clickModalLoginButton();
        homePage.waitLogin();
        homePage.moveToElement(homePage.categoriesButton);
        homePage.moveToElement(homePage.groceryButton);
        GroceryPage groceryPage = homePage.clickGroceryPage();
        pageLoad();
        //Thread.sleep(5000);
        groceryPage.AddUntilFreeShipping();
        CheckoutPage checkoutPage = groceryPage.clickCheckoutButton();
        //Thread.sleep(5000);
        pageLoad();
        Assert.assertTrue(checkoutPage.isFreeShipping(), "The shipping price is not free");
        Assert.assertTrue(checkoutPage.compareAddedProductsWithCheckout(groceryPage.prodList, checkoutPage.getProductList()), "Order List doesn't contain elements added on Grocery Page");

    }
}
