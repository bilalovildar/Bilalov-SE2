package lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TK6Test extends TKabstract {

    @Test
    @Tag("lesson5")
//ТЕСТ-КЕЙС6 (настройки персонализированной рассылки)
    void tk6Test() throws InterruptedException {
        Assertions.assertDoesNotThrow(()->getdriver().get("https://www.bbc.com"), "страница недоступна");
        getdriver().findElement(By.xpath("//span[@id='idcta-username']")).click();
        new WebDriverWait(getdriver(), 10).until(ExpectedConditions.urlContains("account.bbc.com/"));  //явное ожидание что будет этот URL .в том месте где прописали
        Assertions.assertTrue(getdriver().getTitle().equals("BBC – Sign in"), "страница входа недоступна");
        getdriver().findElement(By.xpath("//input[@id='user-identifier-input']")).sendKeys("ildar14444@mail.ru");
        getdriver().findElement(By.xpath("//input[@id='password-input']")).sendKeys("Geekbrains100");
        getdriver().findElement(By.xpath("//button[@id='submit-button']/span")).click();
        Assertions.assertTrue(getdriver().findElement(By.id("idcta-username")).getText().equals("Your account"));
        getdriver().findElement(By.xpath("//span[@id='idcta-username']")).click();           //в ЛК
        getdriver().findElement(By.xpath("//*[@id='container']/div/div[1]/div/div[2]/div/div/div/a")).click();           //в ЛК
        getdriver().findElement(By.xpath("//*[@id='app-container']/div/div/div[2]/div[1]/div[1]/nav/ul/li[2]/a/span")).click();  //Перейти на вкладку “Privacy and cookies” и отключить “Allow personalisation”
        Thread.sleep(1000);
        getdriver().findElement(By.xpath("//*[@id='app-container']/div/div/div[2]/div[2]/div[2]/div/form/div[1]/div[1]/div[2]/button/div/div/label")).click();  //отключить “Allow personalisation
        Thread.sleep(1000); //пауза
        getdriver().findElement(By.xpath("//*[@id='app-container']/div/div/div[2]/div[2]/div[1]/nav/ul/li[4]/a/span")).click(); //Перейти на вкладку “Email preferences” и проверить активность “Discover more with the BBC”
        Thread.sleep(1000);
        getdriver().findElement(By.xpath("//*[@id='app-container']/div/div/div[2]/div[2]/div[2]/div/div[6]/div[1]/div[2]/div/div/label")).click(); //проверить активность “Discover more with the BBC”
        Thread.sleep(1000);
        Assertions.assertTrue(getdriver().findElement(By.xpath("//*[@id='app-container']/div/div/div[2]/div[2]/div[2]/div/div[6]/div[1]/div[3]/div/div[2]/div/button")).getText().equals("Allow personalisation"));
        getdriver().findElement(By.xpath("//*[@id='app-container']/div/div/div[2]/div[2]/div[2]/div/div[6]/div[1]/div[3]/div/div[2]/div/button")).click();  //вернуть как было
    }
}
