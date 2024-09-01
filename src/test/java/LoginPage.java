import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    private final By mailBoxLocator = By.xpath("//input[@id='login-email']");
    private final By passwordBoxLocator = By.id("login-password");
    private final By errorMessageLocator = By.className("ky-error");
    private final By popUpLocator = By.id("cookiescript_accept");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void mailLogin(String mail) {
        WebElement mailElement = driver.findElement(mailBoxLocator);
        mailElement.click();
        mailElement.sendKeys(mail + Keys.TAB);
    }

    public void passwordLogin(String password) {
        WebElement passwordElement = driver.findElement(passwordBoxLocator);
        passwordElement.sendKeys(password + Keys.ENTER);
    }

    public WebElement errorCheck() {
        return driver.findElement(errorMessageLocator);
    }

    public void popUpClick() {
        driver.findElement(popUpLocator).click();
    }
}