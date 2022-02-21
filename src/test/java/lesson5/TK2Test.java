package lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TK2Test extends TKabstract {

    @Test
//ТЕСТ-КЕЙС2 (тестируем ЛОГО сайта)
    void tk2LogoTest() {
        Assertions.assertDoesNotThrow(() -> getdriver().navigate().to("https://www.bbc.com/"), "Страница не доступна");
        Assertions.assertTrue(getdriver().getTitle().equals("BBC - Homepage"), "страница недоступна");
        WebElement webElement = getdriver().findElement(By.xpath("//li[@class='orb-nav-future']/a")); //навести курсор
        webElement.click(); //кликнуть
        getdriver().findElement(By.xpath("//ul/li[@class='orb-nav-newsdotcom']/a")).click();  //кликаем на случаную ссылку
        new WebDriverWait(getdriver(), 3).until(ExpectedConditions.titleContains("Home - BBC News"));  //явное ожидание в том месте где прописали
        getdriver().findElement(By.xpath("//a[@id='homepage-link']")).click();  //ЛОГО должно возвратить на главную страницу
        Assertions.assertTrue(getdriver().getTitle().equals("BBC - Homepage"), "страница входа недоступна");
    }
}
