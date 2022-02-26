package lesson6_7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public abstract class TKabstractTest {

    private static EventFiringWebDriver eventDriver;

    @BeforeAll
    static void init(){
        WebDriverManager.chromedriver().setup();    //установка вебдрайвера Гарсия
        ChromeOptions options = new ChromeOptions();    //создаем перем опций
        options.addArguments("start-maximized");   //во весь экран
        options.addArguments("--incognito");     //режим инкогнито
//        options.addArguments("disable-popup-blocking");  //блокировка всплыв окон
//        options.addArguments("--headless");
        eventDriver = new EventFiringWebDriver(new ChromeDriver(options));
        eventDriver.register(new MyWebDriverEventListener());        // обязательно регистрируем
        eventDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); //неявное ожидание сразу после создания экземпляра WebDriver, действуют в течение всей жизни этого экземпляра
    }


    @BeforeEach
    void initMainPage(){
        Assertions.assertDoesNotThrow( ()-> getdriver().navigate().to("https://www.bbc.com/"),
                "Страница не доступна");
        Assertions.assertTrue(true);
    }

    @AfterAll
    public static void exit(){

        if(eventDriver !=null) eventDriver.quit();
    }
    public WebDriver getdriver() {
        return eventDriver;
    }
}
