package lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static lesson5.teacher.AbstractTest.getDriver;

public class SettingsPageTest extends TKabstractTest {
    //ТЕСТ-КЕЙС5 (редактирование личной карточки-имени)
    @Test
    @Tag("lesson6")
    void changeDisplayNameTest() throws InterruptedException {
        new BBCMainPage(getdriver()).goToAccountPage();
        Assertions.assertTrue(getdriver().getTitle().equals("BBC – Sign in"), "страница входа недоступна");
        new LoginPage(getdriver()).setLogin("ildar14444@mail.ru").setPassword("Geekbrains100").loginIn();
        Assertions.assertTrue(getdriver().findElement(By.id("idcta-username")).getText().equals("Your account"));

        new BBCMainPage(getdriver()).goToAccountPage();
        new AccountPage(getdriver()).goToSettings();
        new SettingsPage(getdriver()).changeDisplayName();
        Assertions.assertTrue(getdriver().findElement(By.xpath("//*[@id='app-container']/div/div/div[2]/div[2]/div[2]/div/div[2]/div[1]/div/p")).getText().equals("New display name saved"));
        new SettingsPage(getdriver()).deleteChangesDisplayName();
        Assertions.assertTrue(getdriver().findElement(By.id("idcta-username")).getText().equals("Your account"));

    }

}
