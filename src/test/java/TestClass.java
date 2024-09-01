import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestClass extends BaseTest {

    BarPage barPage;
    LoginPage loginPage;
    MainPage mainPage;
    SearchResultPage searchResultPage;
    TheProductPage theProductPage;
    OrderPage orderPage;

    @Test
    @Order(1)
    public void barPageTest() {
        barPage = new BarPage(driver);
        barPage.logIn();
    }

    @Test
    @Order(2)
    public void loginPageTest() {
        loginPage = new LoginPage(driver);
        //loginPage.mailLogin("testo@gmail.com");
        //loginPage.passwordLogin("123");

        //WebElement checkWEbElement = loginPage.errorCheck();
        //Assertions.assertNotNull(checkWEbElement, "Error message element is not found.");
        //Assertions.assertTrue(checkWEbElement.isDisplayed(), "Error message is not displayed.");

        loginPage.mailLogin("test35@gmail.com");
        loginPage.passwordLogin("123test123");
    }

    @Test
    @Order(3)
    public void popupTest() {
        loginPage = new LoginPage(driver);
        loginPage.popUpClick();
    }

    @Test
    @Order(4)
    public void bannerCheck() {
        mainPage = new MainPage(driver);
        mainPage.clickMainLogo();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement bannerWebELement = wait.until(ExpectedConditions.visibilityOf(mainPage.getBanner()));
        Assertions.assertTrue(bannerWebELement.isDisplayed());
    }

    @Test
    @Order(5)
    public void searchButtonTest() {
        barPage = new BarPage(driver);
        barPage.bookSearch("1984");
    }

    @Test
    @Order(6)
    public void selectProductTest()
    {
        searchResultPage = new SearchResultPage(driver);
        searchResultPage.clickFirstProduct();
    }

    @Test
    @Order(7)
    public void addToCartTest()throws InterruptedException
    {

        theProductPage = new TheProductPage(driver);
        theProductPage.checkTheProduct();
        theProductPage.addToCartClick();
        Thread.sleep(3000);
        Assertions.assertEquals("1",barPage.getCartNumber());
        barPage.clickToCart();
        Thread.sleep(3000);
        barPage.goToCart();
        Thread.sleep(2000);

    }

    @Test
    @Order(8)
    public void orderDuplicationAndDeleteTest()
    {
        orderPage = new OrderPage(driver);
        orderPage.duplicationCheck();
        orderPage.deleteProduct();
    }

}