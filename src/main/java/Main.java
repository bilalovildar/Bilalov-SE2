import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();    //установка вебдрайвера Гарсия
        ChromeOptions options = new ChromeOptions();    //создаем перем опций
        options.addArguments("start-maximized");   //во весь экран
        options.addArguments("--incognito");     //режим инкогнито
        options.addArguments("disable-popup-blocking");  //блокировка всплыв окон
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); //неявное ожидание

//ТЕСТ-КЕЙС1 (зайти на вкладку О проекте)
//        driver.get("https://journal.tinkoff.ru");  //заходим на сайт
//        WebElement webElement = driver.findElement(By.linkText("О проекте")); //навести курсор
//        webElement.click(); //кликнуть
//        driver.quit(); //закрываем окно

//ТЕСТ-КЕЙС4 (поиск)
        driver.get("https://journal.tinkoff.ru");  //заходим на сайт
        WebElement webElement = driver.findElement(By.cssSelector("css=.loupe--JGOTU")); //находим поле ввода ПОИСК
        webElement.click();  //кликаем на него
        webElement.sendKeys("ипотека"); //ввести поисковое слово
        webElement.submit(); //Enter
        driver.quit(); //закрываем окно

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(webElement));  //явное ожидание в том месте где прописали
        //Thread.sleep(1000);  // будем ждать поток ровно 1000

    }
}


