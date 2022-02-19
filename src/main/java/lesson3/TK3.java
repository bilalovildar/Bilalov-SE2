package lesson3;

import com.fasterxml.jackson.databind.util.ByteBufferBackedInputStream;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class TK3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();    //установка вебдрайвера Гарсия
        ChromeOptions options = new ChromeOptions();    //создаем перем опций
        options.addArguments("start-maximized");   //во весь экран
        options.addArguments("--incognito");     //режим инкогнито
        options.addArguments("disable-popup-blocking");  //блокировка всплыв окон
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); //неявное ожидание сразу после создания экземпляра WebDriver, действуют в течение всей жизни этого экземпляра

////ТЕСТ-КЕЙС3 (проверка виджета погоды на странице)
        driver.get("https://www.bbc.com");  //заходим на сайт
        WebElement webElement = driver.findElement(By.xpath("//a[@class='weather--edit']")); //навести курсор
        webElement.click(); //кликнуть
        driver.findElement(By.xpath("//input[@class='weather--form--input']")).sendKeys("Moscow");  //вводим другой город
        driver.findElement(By.xpath("//button[@class='weather--form--submit']")).click();
    //    webElement.submit();
    //    new WebDriverWait(driver, 3).until(ExpectedConditions.textToBePresentInElement((WebElement) By.xpath("//li[@class='weather--result']"), "Moscow, Russia"));  //явное ожидание в том месте где прописали
    //Вопрос: почему не отрабатывает явное ожидание сверху?
        driver.quit(); //закрываем окно
//        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(webElement));  //явное ожидание в том месте где прописали
//      Thread.sleep(1000);  // будем ждать поток ровно 1000

    }
}
