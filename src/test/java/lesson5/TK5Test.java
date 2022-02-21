package lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TK5Test extends TKabstract {

    @Test
    @Tag("lesson5")
//ТЕСТ-КЕЙС5 (редактирование личной карточки-имени)
    void tk5Test() throws InterruptedException {
        Assertions.assertDoesNotThrow(()->getdriver().get("https://www.bbc.com"), "страница недоступна");
        getdriver().findElement(By.xpath("//span[@id='idcta-username']")).click();
        new WebDriverWait(getdriver(), 10).until(ExpectedConditions.urlContains("account.bbc.com/"));  //явное ожидание что будет этот URL .в том месте где прописали
        Assertions.assertTrue(getdriver().getTitle().equals("BBC – Sign in"), "страница входа недоступна");
        getdriver().findElement(By.xpath("//input[@id='user-identifier-input']")).sendKeys("ildar14444@mail.ru");
        getdriver().findElement(By.xpath("//input[@id='password-input']")).sendKeys("Geekbrains100");
        getdriver().findElement(By.xpath("//button[@id='submit-button']/span")).click();
        Assertions.assertTrue(getdriver().findElement(By.id("idcta-username")).getText().equals("Your account"));
        getdriver().findElement(By.xpath("//span[@id='idcta-username']")).click();
        getdriver().findElement(By.xpath("//*[@id='container']/div/div[1]/div/div[2]/div/div/div/a")).click();
        Thread.sleep(1000);
        getdriver().findElement(By.xpath("//*[@id='Display name-field']/div[2]/a/div")).click();
        Thread.sleep(1000);
        getdriver().findElement(By.xpath("//*[@id='displayName-input']")).sendKeys("Ildar");
        getdriver().findElement(By.xpath("//*[@id='app-container']/div/div/div[2]/div[1]/div[2]/div/div[2]/form/div[2]/button")).click();
        Assertions.assertTrue(getdriver().findElement(By.xpath("//*[@id='app-container']/div/div/div[2]/div[2]/div[2]/div/div[2]/div[1]/div/p")).getText().equals("New display name saved"));
        Thread.sleep(1000);
        getdriver().findElement(By.xpath("//*[@id='Display name-field']/div[2]/a/div")).click();
        Thread.sleep(1000);
        getdriver().findElement(By.xpath("//*[@id='displayName-input']")).sendKeys("\b\b\b\b\b");
        getdriver().findElement(By.xpath("//*[@id='app-container']/div/div/div[2]/div[1]/div[2]/div/div[2]/form/div[2]/button")).click();
        Assertions.assertTrue(getdriver().findElement(By.id("idcta-username")).getText().equals("Your account"));
    }
}
