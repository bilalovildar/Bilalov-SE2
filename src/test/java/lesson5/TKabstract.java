package lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public abstract class TKabstract {

    private static WebDriver driver;

    @BeforeAll
    static void init(){
        WebDriverManager.chromedriver().setup();    //установка вебдрайвера Гарсия
        ChromeOptions options = new ChromeOptions();    //создаем перем опций
        options.addArguments("start-maximized");   //во весь экран
        options.addArguments("--incognito");     //режим инкогнито
//        options.addArguments("disable-popup-blocking");  //блокировка всплыв окон
//        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); //неявное ожидание сразу после создания экземпляра WebDriver, действуют в течение всей жизни этого экземпляра
    }


//    @BeforeEach
//    void goTo(){
//        Assertions.assertDoesNotThrow(()->driver.get("https://www.bbc.com"), "страница недоступна");  //заходим на сайт с проверкой на Exception (с универсальной проверкой)
//    }

    @AfterAll
    static void driverclose(){
//        driver.quit();
    }
    public WebDriver getdriver() {
        return driver;
    }
}
