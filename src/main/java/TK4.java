import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class TK4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();    //установка вебдрайвера Гарсия
        ChromeOptions options = new ChromeOptions();    //создаем перем опций
        options.addArguments("start-maximized");   //во весь экран
        options.addArguments("--incognito");     //режим инкогнито
        options.addArguments("disable-popup-blocking");  //блокировка всплыв окон
        WebDriver driver = new ChromeDriver(options);   //созданиt экземпляра WebDriver
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); //неявное ожидание сразу после создания экземпляра WebDriver, действуют в течение всей жизни этого экземпляра

//ТЕСТ-КЕЙС4 (проверка поля ввода ПОИСКА)
        driver.get("https://www.bbc.com");  //заходим на сайт
        WebElement webElement = driver.findElement(By.xpath("//*[@id='orb-search-q']")); //навести курсор
        webElement.click(); //кликнуть
        webElement.sendKeys("Macron");
        webElement.submit();
        driver.findElement(By.xpath("//a[@href='https://www.bbc.com']")).click();
        driver.findElement(By.xpath("//input[@id='orb-search-q']")).sendKeys("DROP TABLE USERS");  //sql-инъекция
        driver.findElement(By.xpath("//button[@id='orb-search-button']")).click();
        driver.findElement(By.xpath("//a[@href='https://www.bbc.com']")).click();
        driver.findElement(By.xpath("//input[@id='orb-search-q']")).sendKeys("<script>alert(\"I hacked this!\")</script>");  //проверка уязвимости для XSS-атаки
        driver.findElement(By.xpath("//button[@id='orb-search-button']")).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(webElement));  //явное ожидание в том месте где прописали
        driver.quit(); //закрываем окно
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(webElement));  //явное ожидание в том месте где прописали
//      Thread.sleep(1000);  // будем ждать поток ровно 1000

    }
}
