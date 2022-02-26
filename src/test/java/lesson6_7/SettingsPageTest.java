package lesson6_7;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class SettingsPageTest extends TKabstractTest {
    //ТЕСТ-КЕЙС5 (редактирование личной карточки-имени)
    @Test
    @Tag("lesson6_7")
    @DisplayName("ТЕСТ-КЕЙС5 (редактирование личной карточки-имени)")
    @Description("Описание: В ЛК изменяется имя, проверяется уведомление и возврат как было")
    @Link("http://google.com")
    @Issue("https://bbc.com")
    @Severity(SeverityLevel.TRIVIAL)
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
    @Test
    @DisplayName("Сделай скрин для ТК5")
    @Description("Тест создает скрин")
    @Link("http://google.com")
    @Issue("https://bbc.com")
    @Severity(SeverityLevel.BLOCKER)
    void testFalse() throws InterruptedException, IOException {
        Thread.sleep(1000);
        File file = MyUtils.makeScreenshot(getdriver(),"failure- org.example.bbc.MyShowTest.testFalse" + System.currentTimeMillis() + ".png");
        saveScreenshot(Files.readAllBytes(file.toPath()));
        Assertions.assertTrue(true);
    }

    @Step("Степ 1")
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

}
