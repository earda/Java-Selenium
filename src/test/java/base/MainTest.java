package base;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.*;
public class MainTest {
    public static WebDriver driver;
    public static Logger logger = Logger.getLogger(MainTest.class);

        @BeforeTest
        public void setUpDriver() {
        String baseUrl = "https://www.hepsiburada.com/";
        ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            options.setExperimentalOption("useAutomationExtension", false);
        System.setProperty("webdriver.chrome.driver","webdriver/chromedriver.exe");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
        Assert.assertEquals("Türkiye'nin En Çok Tavsiye Edilen E-ticaret Markası Hepsiburada", driver.getTitle());

        String pageTitle = driver.getTitle();
        if (pageTitle.contains("Hepsiburada")) {
            System.out.println("Ana sayfa başarıyla açıldı. Sayfa başlığı: " + pageTitle);
        } else {
            System.out.println("Ana sayfa açılmadı. Sayfa başlığı: " + pageTitle);
        }

    }
}
