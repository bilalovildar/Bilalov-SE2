package lesson6_7;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.List;

public class LoginTest extends TKabstractTest {
// ТК1  проверка авторизации
    @Feature("Новая Фича 1")
    @Test
    @Tag("lesson6_7")
    @DisplayName("TK1 проверка авторизации")
    @Description("Описание: авторизация логин и пароль")
    @Link("http://google.com")
    @Issue("https://bbc.com")
    @Severity(SeverityLevel.CRITICAL)
    void loginIn(){
        new BBCMainPage(getdriver()).goToAccountPage();
        Assertions.assertTrue(getdriver().getTitle().equals("BBC – Sign in"), "страница входа недоступна");
        new LoginPage(getdriver()).setLogin("ildar14444@mail.ru").setPassword("Geekbrains100").loginIn();
        Assertions.assertTrue(getdriver().findElement(By.id("idcta-username")).getText().equals("Your account"));

    }

   /* @Test
    void tk1Test() {
        Assertions.assertDoesNotThrow(()->getdriver().get("https://www.bbc.com"), "страница недоступна");
//        WebElement webElement2 = getdriver().findElement(By.xpath("//span[@id='idcta-username']")); //навести курсор
//        webElement2.click(); //кликнуть
        getdriver().findElement(By.xpath("//span[@id='idcta-username']")).click();
        new WebDriverWait(getdriver(), 10).until(ExpectedConditions.urlContains("account.bbc.com/"));  //явное ожидание что будет этот URL .в том месте где прописали
        Assertions.assertTrue(getdriver().getTitle().equals("BBC – Sign in"), "страница входа недоступна");
        getdriver().findElement(By.xpath("//input[@id='user-identifier-input']")).sendKeys("ildar14444@mail.ru");
        getdriver().findElement(By.xpath("//input[@id='password-input']")).sendKeys("Geekbrains100");
        getdriver().findElement(By.xpath("//button[@id='submit-button']/span")).click();
        Assertions.assertTrue(getdriver().findElement(By.id("idcta-username")).getText().equals("Your account"));
    }*/

//
//   @Test
//   @Tag("lesson6_7")
//   @DisplayName("Сделай скрин для ТК1")
//   @Description("Тест создает скрин")
//   @Link("http://google.com")
//   @Issue("https://bbc.com")
//   @Severity(SeverityLevel.BLOCKER)
//   void testFalse() throws InterruptedException, IOException {
//       Thread.sleep(1000);
//       File file = MyUtils.makeScreenshot(getdriver(),"failure- org.example.bbc.MyShowTest.testFalse" + System.currentTimeMillis() + ".png");
//       saveScreenshot(Files.readAllBytes(file.toPath()));
//       Assertions.assertTrue(true);
//   }
//
//    @Step("Степ 1")
//    @Attachment(value = "Page screenshot", type = "image/png")
//    public byte[] saveScreenshot(byte[] screenShot) {
//        return screenShot;
//    }
//
//    @Test
//    @Tag("lesson6_7")
//    @DisplayName("Дай логи браузера")
//    @Description("Создаем логи браузера если allLogRows.size() > 0 ")
//    @Link("http://google.com")
//    @Issue("https://bbc.com")
//    @Severity(SeverityLevel.NORMAL)
//    void testLogs(){
//        LogEntries browserLogs = getdriver().manage().logs().get(LogType.BROWSER);
//        List<LogEntry> allLogRows = browserLogs.getAll();
//       /* Assertions.assertEquals(0,allLogRows.size());
//        Assertions.assertTrue(allLogRows.isEmpty());*/
//        if (allLogRows.size() > 0 ) {
//            allLogRows.forEach(logEntry -> {
//                System.out.println(logEntry.getMessage());
//            });
//
//        }
//    }

    @AfterEach
    void logout(){
        new BBCMainPage(getdriver()).goToAccountPage();
        Assertions.assertTrue(getdriver().getTitle().equals("BBC – account overview"), "страница аккаунта не доступна");
        new AccountPage(getdriver()).logOut();
        new WebDriverWait(getdriver(),Duration.ofSeconds(5));
        Assertions.assertTrue(getdriver().findElement(By.id("idcta-username")).getText().equals("Sign in"));
    }


}
