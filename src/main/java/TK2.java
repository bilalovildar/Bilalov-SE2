import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class TK2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();    //установка вебдрайвера Гарсия
        ChromeOptions options = new ChromeOptions();    //создаем перем опций
        options.addArguments("start-maximized");   //во весь экран
        options.addArguments("--incognito");     //режим инкогнито
        options.addArguments("disable-popup-blocking");  //блокировка всплыв окон
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); //неявное ожидание сразу после создания экземпляра WebDriver, действуют в течение всей жизни этого экземпляра

//ТЕСТ-КЕЙС2 (тестируем ЛОГО сайта)
        driver.get("https://www.bbc.com");  //заходим на сайт
        WebElement webElement = driver.findElement(By.xpath("//li[@class='orb-nav-future']/a")); //навести курсор
        webElement.click(); //кликнуть
        driver.findElement(By.xpath("//img[@title='Artwork of helicopter above Mars (Credit: Nasa/JPL)']")).click();  //кликаем на картинку-ссылку
        new WebDriverWait(driver, 3).until(ExpectedConditions.titleContains("The drones that will fly in alien skies"));  //явное ожидание в том месте где прописали
        driver.findElement(By.xpath("//a[@id='homepage-link']")).click();  //ЛОГО должно возвратить на главную страницу
        new WebDriverWait(driver, 4).until(ExpectedConditions.visibilityOf(webElement));  //явное ожидание в том месте где прописали
        driver.quit(); //закрываем окно
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(webElement));  //явное ожидание в том месте где прописали
//      Thread.sleep(1000);  // будем ждать поток ровно 1000

    }
}
