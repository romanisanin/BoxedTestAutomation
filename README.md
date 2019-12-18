### Boxed Test Automation Framework
Test Automation Framework is a good starting point to write automated tests for website Boxed.com utilizing Java, Selenium based on Page Object Model desing pattern.

### Libraries and Frameworks
Version for some of these can be found in the [POM](https://github.com/romanisanin/BoxedTestAutomation/blob/master/pom.xml "POM") file.

Selenium - Web automation
Maven - Build and package management
TestNG - Test execution and Reporting

### Test-Scenarios:
Currenly, three test scenarios can be executed:
1. Log in as a user, and verify the user is logged in
2. Log in as a user, navigate to Cookies page(Categories->Snacks>Cookies from the top menu/side
menu), favorite some items and verify those items are present in the Favorites page(reachable
from the top menu/side menu)
3. Log in as a user, navigate to All Grocery page, add items to cart until free shipping minimum is
met, navigate to checkout and verify that the items in checkout page are same as items in the
cart and that shipping cost is zero

All tests located in the file \src\test\java\base\Tests.java in the methods:
1. testSuccessfulLogin
2. testAddFavoriteItems
3. testFreeShipping

Page classes contain web elements and methods to interact with web elements.
Page classes located in \src\main\java\pages directory;
