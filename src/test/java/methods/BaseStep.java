package methods;

import base.MainTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BaseStep extends MainTest {

    Duration duration = Duration.ofSeconds(60);
    WebDriverWait webDriverWait= new WebDriverWait(driver,duration);
    JavascriptExecutor jsDriver=(JavascriptExecutor) driver;

    public  void waitClicableClick(By by) {
        WebElement webElement =webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        webElement.click();
      //  logger.info("Elementi görüldü ve elemente tıklandı!");

    }
    public  void directClicableClick(By by) {
        WebElement element = driver.findElement(by);
        element.click();
        //  logger.info("Elementi görüldü ve elemente tıklandı!");

    }
    public void waitVisibilitySendKey(By by, String key) {
        WebElement webElement= webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        webElement.sendKeys(key);
      //  logger.info("'Detechted ve  "+key+" değeri girildi!");

    }
    public void waitVisibilitySendKeyEnter(By by, String key) {
        WebElement webElement= webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        webElement.click();
        webElement.sendKeys(key);
        webElement.sendKeys(Keys.ENTER);
      //  logger.info("'Detechted ve  "+key+" değeri girildi!");

    }
    public  void waitBySeconds(int seconds) {
        try {
           // logger.info(seconds + " Saniye Bekle");
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public  void waitVisibilityClick(By by) {
        WebElement webElement=webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        webElement.click();
       // logger.info("Clicked element!");
    }
    public WebElement findElement(By by){
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        return driver.findElement(by);
    }

    public void scrollElement(By by){
        WebElement webElement = findElement(by);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        jsDriver.executeScript("arguments[0].scrollIntoView();", webElement);
        focusElement(webElement);
    }
    public void scrollToElement(WebElement webElement) {
         try {
             JavascriptExecutor javascriptExecuter=(JavascriptExecutor) driver;
             javascriptExecuter.executeScript("arguments[0].scrollIntoView();", webElement);
        }catch(Exception ex) {
            String errorMessage=String.format("Elementine scroll alırken sorun oluştu! Element:",webElement,ex.getMessage());

        throw new RuntimeException(ex);
        }
}
    public void focusElement(WebElement webElement){
        jsDriver.executeScript("arguments[0].focus();", webElement);
    }
    public void cleanCache(){
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }
}
