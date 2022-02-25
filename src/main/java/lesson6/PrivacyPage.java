package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrivacyPage extends AbstractPage {

    @FindBy(xpath = "//*[@id='app-container']/div/div/div[2]/div[2]/div[2]/div/form/div[1]/div[1]/div[2]/button/div/div/label")
    private WebElement AllowPersonalisation;

        public PrivacyPage(WebDriver driver) {
        super(driver);
    }

    public void changeAllowPersonalisation() throws InterruptedException {
        this.AllowPersonalisation.click();
        Thread.sleep(1000);
//        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("privacy"));
    }
}
