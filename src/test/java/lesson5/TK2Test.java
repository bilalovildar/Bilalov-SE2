package lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class TK2Test extends TKabstract {

@Test
//ТЕСТ-КЕЙС2 (тестируем ЛОГО сайта)
        void tk2LogoTest(){
        Assertions.assertDoesNotThrow( ()-> getdriver().navigate().to("https://www.bbc.com/"), "Страница не доступна");
        Actions logoClick = new Actions(getdriver());
        logoClick.click(getdriver().findElement(By.xpath("//li[@class='orb-nav-future']/a")))
                .pause(100)
                .click(getdriver().findElement(By.xpath("//*[@id='article-hero-img-js']")))            //случайный переход
                .pause(100)
                .click(getdriver().findElement(By.xpath("//a[@id='homepage-link']")))               //ЛОГО должно возвратить на главную страницу
                .build()       //обязательно
                .perform();    //обязательно
        Assertions.assertEquals("BBC – Sign in", getdriver().getTitle(), "BBC - Homepage");

//      new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(webElement));  //явное ожидание в том месте где прописали
//      Thread.sleep(1000);  // будем ждать поток ровно 1000
    }
}
