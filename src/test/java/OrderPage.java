import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {

    private final By productDuplicationLocator = By.xpath("//input[@name='quantity']");
    private final By deleteProductLocator = By.xpath("//i[@class='fa fa-times red-icon']");
    WebDriver driver;
    public OrderPage(WebDriver driver)
    {
        this.driver=driver;
    }



    public Boolean duplicationCheck() {
        WebElement duplicateCheck = driver.findElement(productDuplicationLocator);
        duplicateCheck.click();
        duplicateCheck.sendKeys(Keys.BACK_SPACE);

        String valueToSend = "2";
        duplicateCheck.sendKeys(valueToSend);

        String enteredValue = duplicateCheck.getAttribute("value");

        return valueToSend.equals(enteredValue);
    }

    public void deleteProduct ()
    {

        driver.findElement(deleteProductLocator).click();

    }
}
