package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class TK1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();    //установка вебдрайвера Гарсия
        ChromeOptions options = new ChromeOptions();    //создаем перем опций
        options.addArguments("start-maximized");   //во весь экран
        options.addArguments("--incognito");     //режим инкогнито
        options.addArguments("disable-popup-blocking");  //блокировка всплыв окон
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); //неявное ожидание сразу после создания экземпляра WebDriver, действуют в течение всей жизни этого экземпляра

//ТЕСТ-КЕЙС1 (Авторизация почта/пароль)

        driver.get("https://www.bbc.com");  //заходим на сайт
        WebElement webElement = driver.findElement(By.xpath("//span[@id='idcta-username']")); //навести курсор
        webElement.click(); //кликнуть
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains("account.bbc.com/"));  //явное ожидание что будет этот URL .в том месте где прописали
        driver.findElement(By.xpath("//input[@id='user-identifier-input']")).sendKeys("ildar14444@mail.ru");
        driver.findElement(By.xpath("//input[@id='password-input']")).sendKeys("Geekbrains100");
        driver.findElement(By.xpath("//button[@id='submit-button']/span")).click();
        driver.quit(); //закрываем окно
//        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(webElement));  //явное ожидание в том месте где прописали
//      Thread.sleep(1000);  // будем ждать поток ровно 1000

    }
}


