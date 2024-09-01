import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private final WebDriver driver;
    private final By bannerLocator = By.cssSelector(".swiper-button-prev.common-sprite.desktop-banner-prev");

    private final By mainPageLogoLocator = By.className("logo-text");
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getBanner() {
        return driver.findElement(bannerLocator);
    }

    public void clickMainLogo()
    {
        driver.findElement(mainPageLogoLocator).click();
    }
}