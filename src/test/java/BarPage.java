import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BarPage {

    private final WebDriver driver;

    private final By logInButtonLocator = By.cssSelector(".menu-top-button.login");
    private final By searchBoxLocator = By.id("search-input");
    private final  By cartNumberLocator= By.xpath("//span[@id='cart-items']");
    private final By goToCartLocator = By.id("js-cart");
    public BarPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logIn() {
        driver.findElement(logInButtonLocator).click();
    }

    public void bookSearch(String searchword) {
        WebElement searchElement = driver.findElement(searchBoxLocator);
        searchElement.click();
        searchElement.sendKeys(searchword + Keys.ENTER);
    }

    public String getCartNumber ()
    {

        return driver.findElement(cartNumberLocator).getText();

    }
    public void clickToCart()
    {
        driver.findElement(cartNumberLocator).click();
    }
    public void goToCart()
    {
        driver.findElement(goToCartLocator).click();
    }
}