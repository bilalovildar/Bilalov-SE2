package lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TK1Test extends TKabstract {

    @Test
    @Tag("lesson5")
//ТЕСТ-КЕЙС1 (Авторизация почта/пароль)
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
        getdriver().quit(); //закрываем окно
        Assertions.assertTrue(getdriver().findElement(By.id("idcta-username")).getText().equals("Your account"));
    }
//      new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(webElement));  //явное ожидание в том месте где прописали
//      Thread.sleep(1000);  // будем ждать поток ровно 1000
}
