package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends AbstractPage {

    @FindBy(xpath = ".//span[text()='Sign out']")
    private WebElement exit;

    @FindBy(xpath = "//*[@id='container']/div/div[1]/div/div[2]/div/div/div/a")
    private WebElement settingsOfCabinet;

    @FindBy(xpath = "//*[@id='app-container']/div/div/div[2]/div[1]/div[1]/nav/ul/li[2]/a")
    private WebElement privatOfCabinet;

    @FindBy(xpath = "//*[@id='app-container']/div/div/div[2]/div[2]/div[1]/nav/ul/li[4]/a/span")
    private WebElement emailOfCabinet;

    public AccountPage(WebDriver driver){
        super(driver);
    }

    public void logOut(){
        this.exit.click();
    }
    public void goToSettings(){
        this.settingsOfCabinet.click();
    }
    public void goToPrivatOfCabinet() throws InterruptedException {
        Thread.sleep(1000);
        this.privatOfCabinet.click();
        Thread.sleep(2000);
    }
    public void goToEmailOfCabinet() throws InterruptedException {
        Thread.sleep(1000);
        this.emailOfCabinet.click();
    }

}
