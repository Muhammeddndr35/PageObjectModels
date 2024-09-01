import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TheProductPage {
    WebDriver driver;

    private final By checkTheProductLocator = By.className("book-front");
    private final By addToCartLocator = By.xpath("//a[@id='button-cart']");

    public TheProductPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void checkTheProduct()
    {
        WebElement checkToProduct = driver.findElement(checkTheProductLocator);
        Assertions.assertTrue(checkToProduct.isDisplayed());
        Assertions.assertNotNull(checkToProduct, "Product element was not found.");

    }

    public void addToCartClick()
    {
        driver.findElement(addToCartLocator).click();
    }

}
