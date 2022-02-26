package lesson6_7;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class BBCMainPageSearchTest extends TKabstractTest {
// ТК4  проверка поля поиска главной страницы
    @Test
    @Tag("lesson6_7")
    @DisplayName("проверка поля поиска главной страницы")
    @Description("Описание: в поиск задается слово и выводятся рез-ты")
    @Link("http://google.com")
    @Issue("https://bbc.com")
    @Severity(SeverityLevel.MINOR)
    void MainPageSearchTest() {
        new BBCMainPage(getdriver()).inputSearch();
        Assertions.assertTrue(getdriver().getTitle().equals("BBC - Search results for Macron"), "отфильтрованная страница с поиском не открылась");
    }
    @Test
    @Tag("lesson6_7")
    @DisplayName("Сделай скрин для ТК4")
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
