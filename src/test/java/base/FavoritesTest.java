package base;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FavoritesTest extends baseTests {
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
                "Alert text is incorrect");
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
    }
}
