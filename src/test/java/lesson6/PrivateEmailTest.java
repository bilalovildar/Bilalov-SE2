package lesson6;

import lesson5.teacher.AbstractTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PrivateEmailTest extends TKabstractTest {
    //ТЕСТ-КЕЙС6 (настройки персонализированной рассылки)
    @Test
    @Tag("lesson6")
    void privateEmailTest() throws InterruptedException {
        new BBCMainPage(getdriver()).goToAccountPage();
        Assertions.assertTrue(getdriver().getTitle().equals("BBC – Sign in"), "страница входа недоступна");
        new LoginPage(getdriver()).setLogin("ildar14444@mail.ru").setPassword("Geekbrains100").loginIn();
        Assertions.assertTrue(getdriver().findElement(By.id("idcta-username")).getText().equals("Your account"));

        new BBCMainPage(getdriver()).goToAccountPage();
        new AccountPage(getdriver()).goToSettings();
        new AccountPage(getdriver()).goToPrivatOfCabinet();
        new PrivacyPage(getdriver()).changeAllowPersonalisation();
        new AccountPage(getdriver()).goToEmailOfCabinet();
        new EmailPage(getdriver()).changeDiscoverMoreWithTheBBC();
        Assertions.assertTrue(getdriver().findElement(By.xpath("//*[@id='app-container']/div/div/div[2]/div[2]/div[2]/div/div[6]/div[1]/div[3]/div/div[2]/div/button")).getText().equals("Allow personalisation"));
        new EmailPage(getdriver()).onAllowPersonalisationFromEmailPage();
    }
}
