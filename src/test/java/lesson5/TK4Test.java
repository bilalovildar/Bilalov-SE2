package lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TK4Test extends TKabstract {
    @Test
    @Tag("lesson5")
    public void tk3Test() {

//ТЕСТ-КЕЙС4 (проверка поля ввода ПОИСКА)
        Assertions.assertDoesNotThrow(() -> getdriver().navigate().to("https://www.bbc.com/"), "Страница не доступна");
        Assertions.assertTrue(getdriver().getTitle().equals("BBC - Homepage"), "страница недоступна");
        WebElement webElement = getdriver().findElement(By.xpath("//*[@id='orb-search-q']")); //навести курсор
        webElement.click(); //кликнуть
        webElement.sendKeys("Macron");
        webElement.submit();
        Assertions.assertTrue(getdriver().getTitle().equals("BBC - Search results for Macron"), "отфильтрованная страница с поиском не открылась");
        getdriver().findElement(By.xpath("//a[@href='https://www.bbc.com']")).click();
        getdriver().findElement(By.xpath("//input[@id='orb-search-q']")).sendKeys("нггнанг!*/*fytfghj");  //негативный поиск
        getdriver().findElement(By.xpath("//button[@id='orb-search-button']")).click();
        Assertions.assertTrue(getdriver().getTitle().equals("BBC - Search results for нггнанг!*/*fytfghj"), "отфильтрованная страница с поиском не открылась");
        Assertions.assertTrue(getdriver().findElement(By.xpath("//div[@class='ssrcss-1wctgia-Stack e1y4nx260']/p")).getText().equals("Sorry, there are no results for нггнанг!*/*fytfghj."));
    }
}
