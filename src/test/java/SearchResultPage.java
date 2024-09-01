import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {
    WebDriver driver;



    private final By productLocator = By.className("pr-img-link");

    public SearchResultPage(WebDriver driver)
    {

        this.driver = driver;

    }

    public void clickFirstProduct()
    {
        driver.findElement(productLocator).click();
    }


}
