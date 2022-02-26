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

public class BBCMainPageWeatherTest extends TKabstractTest {
// ТК3 проверка виджета погоды
    @Test
    @Tag("lesson6_7")
    @DisplayName("проверка виджета погоды")
    @Description("Описание: жмем edit, затем вбиваем в поле город")
    @Link("http://google.com")
    @Issue("https://bbc.com")
    @Severity(SeverityLevel.CRITICAL)
    void setCityWeather() {
        new BBCMainPage(getdriver()).changeCityWeather();
        Assertions.assertTrue(getdriver().findElement(By.xpath("//li[@class='weather--result']")).getText().equals("Moscow, Russia"));
    }
    @Test
    @Tag("lesson6_7")
    @DisplayName("Сделай скрин для ТК3")
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
