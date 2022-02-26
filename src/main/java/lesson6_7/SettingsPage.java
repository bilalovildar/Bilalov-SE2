package lesson6_7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SettingsPage extends AbstractPage {

    @FindBy(xpath = "//*[@id='Display name-field']/div[2]/a/div")
    private WebElement editInputNameInSettingsPage;

    @FindBy(xpath = "//*[@id='displayName-input']")
    private WebElement inputNameInSettingsPage;

    @FindBy(xpath = "//*[@id='app-container']/div/div/div[2]/div[1]/div[2]/div/div[2]/form/div[2]/button")
    private WebElement buttonSaveDisplayName;

    @FindBy(xpath = "//*[@id='app-container']/div/div/div[2]/div[1]/div[1]/nav/ul/li[2]/a/span")
    private WebElement PrivacyAndCookies;

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    public SettingsPage changeDisplayName() throws InterruptedException {
        Thread.sleep(1000);
        this.editInputNameInSettingsPage.click();
        Thread.sleep(1000);
        this.inputNameInSettingsPage.sendKeys("Ildar");
        this.buttonSaveDisplayName.click();
        Thread.sleep(1000);
        return this;
    }

    public void deleteChangesDisplayName() throws InterruptedException {
        Thread.sleep(1000);
        this.editInputNameInSettingsPage.click();
        Thread.sleep(1000);
        this.inputNameInSettingsPage.sendKeys("\b\b\b\b\b");
        this.buttonSaveDisplayName.click();
        Thread.sleep(1000);
    }

    public void goToPrivacyAndCookies(){
        this.PrivacyAndCookies.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("privacy"));
    }
}
