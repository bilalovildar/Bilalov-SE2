package lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class BBCMainPageWeatherTest extends TKabstractTest {
// ТК3 проверка виджета погоды
    @Test
    @Tag("lesson6")
    void setCityWeather() {
        new BBCMainPage(getdriver()).changeCityWeather();
        Assertions.assertTrue(getdriver().findElement(By.xpath("//li[@class='weather--result']")).getText().equals("Moscow, Russia"));
    }
}
