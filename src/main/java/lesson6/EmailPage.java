package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends AbstractPage {

    @FindBy(xpath = "//*[@id='app-container']/div/div/div[2]/div[2]/div[2]/div/div[6]/div[1]/div[2]/div/div/label")
    private WebElement DiscoverMoreWithTheBBC;

    @FindBy(xpath = "//*[@id='app-container']/div/div/div[2]/div[2]/div[2]/div/div[6]/div[1]/div[3]/div/div[2]/div/button")
    private WebElement AllowPersonalisationFromEmailPage;

    public EmailPage(WebDriver driver) {
        super(driver);
    }

    public void changeDiscoverMoreWithTheBBC() throws InterruptedException {
        Thread.sleep(2000);
        this.DiscoverMoreWithTheBBC.click();
//        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("privacy"));
    }

    public void onAllowPersonalisationFromEmailPage() {
        this.AllowPersonalisationFromEmailPage.click();
    }
}
