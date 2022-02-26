package lesson6_7;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class EventListenerTest extends TKabstractTest{

    @Test
    @Tag("lesson6_7")
    void test(){
        WebElement webElement = getdriver().findElement(By.cssSelector("div.orb-nav-section.orb-nav-links.orb-nav-focus>ul>li.orb-nav-sport>a"));
        webElement.click();

        try {
            getdriver().findElement(By.id("нет такого локатора, делаем скрин поэтому"));
        } catch (NoSuchElementException e){
            MyUtils.makeScreenshot(getdriver(),
                    "failure- org.example.bbc.EventListenerTest.test" + System.currentTimeMillis() + ".png");
        }

    }
    @Test
    @Tag("lesson6_7")
    @DisplayName("Сделай скрин просто так")
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
