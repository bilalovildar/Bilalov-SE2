package lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TK3Test extends TKabstract {
    @Test
    @Tag("lesson5")
    public void tk3Test() {
////ТЕСТ-КЕЙС3 (проверка виджета погоды на странице)
        Assertions.assertDoesNotThrow(() -> getdriver().navigate().to("https://www.bbc.com/"), "Страница не доступна");
        Assertions.assertTrue(getdriver().getTitle().equals("BBC - Homepage"), "страница входа недоступна");
        WebElement webElement = getdriver().findElement(By.xpath("//a[@class='weather--edit']")); //навести курсор
        webElement.click(); //кликнуть
        getdriver().findElement(By.xpath("//input[@class='weather--form--input']")).sendKeys("Moscow");  //вводим другой город
        getdriver().findElement(By.xpath("//button[@class='weather--form--submit']")).click();
        Assertions.assertTrue(getdriver().findElement(By.xpath("//li[@class='weather--result']")).getText().equals("Moscow, Russia"));
    }
}
