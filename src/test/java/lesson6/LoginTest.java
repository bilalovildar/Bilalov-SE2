package lesson6;

import lesson5.teacher.AbstractTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTest extends TKabstractTest {
// ТК1  проверка авторизации
    @Test
    @Tag("lesson6")
    void loginIn(){
        new BBCMainPage(getdriver()).goToAccountPage();
        Assertions.assertTrue(getdriver().getTitle().equals("BBC – Sign in"), "страница входа недоступна");
        new LoginPage(getdriver()).setLogin("ildar14444@mail.ru").setPassword("Geekbrains100").loginIn();
        Assertions.assertTrue(getdriver().findElement(By.id("idcta-username")).getText().equals("Your account"));

    }

   /* @Test
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
        Assertions.assertTrue(getdriver().findElement(By.id("idcta-username")).getText().equals("Your account"));
    }*/

    @AfterEach
    void logout(){
        new BBCMainPage(getdriver()).goToAccountPage();
        Assertions.assertTrue(getdriver().getTitle().equals("BBC – account overview"), "страница аккаунта не доступна");
        new AccountPage(getdriver()).logOut();
        new WebDriverWait(getdriver(),Duration.ofSeconds(5));
        Assertions.assertTrue(getdriver().findElement(By.id("idcta-username")).getText().equals("Sign in"));
    }
}
