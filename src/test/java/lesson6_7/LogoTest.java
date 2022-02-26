package lesson6_7;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class LogoTest extends TKabstractTest {
// TK2 проверка ЛОГО сайта , должно возвращать на главную страницу
    @Test
    @Order(1)
    @Tag("lesson6_7")
    @DisplayName("TK2 проверка ЛОГО сайта , должно возвращать на главную страницу")
    @Description("Описание: переход на СПОРТ")
    @Link("http://google.com")
    @Issue("https://bbc.com")
    @Severity(SeverityLevel.CRITICAL)
    void clickToSport(){
        new BBCMainPage(getdriver()).navigateToSport();
        Assertions.assertEquals("https://www.bbc.com/sport",getdriver().getCurrentUrl());
    }

    @Test
    @Order(2)
    @Tag("lesson6_7")
    @DisplayName("TK2 проверка ЛОГО сайта , должно возвращать на главную страницу")
    @Description("Описание: переход на TRAVEL")
    @Link("http://google.com")
    @Issue("https://bbc.com")
    @Severity(SeverityLevel.CRITICAL)
    void clickToTravel(){
        new BBCMainPage(getdriver()).navigateToTravel();
        Assertions.assertEquals("https://www.bbc.com/travel",getdriver().getCurrentUrl());
    }

    @Test
    @Order(3)
    @Tag("lesson6_7")
    @DisplayName("TK2 проверка ЛОГО сайта , должно возвращать на главную страницу")
    @Description("Описание: переход на LOGO")
    @Link("http://google.com")
    @Issue("https://bbc.com")
    @Severity(SeverityLevel.BLOCKER)
    void clickToLogo(){
        new BBCMainPage(getdriver()).navigateToLogo();
        Assertions.assertTrue(getdriver().getTitle().equals("BBC - Homepage"), "страница входа недоступна");
    }
    @Test
    @Tag("lesson6_7")
    @DisplayName("Сделай скрин для ТК2")
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
