package step;

import methods.BaseStep;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static constant.Constants.*;

public class StepImplementation extends BaseStep {
    public static Logger logger = Logger.getLogger(StepImplementation.class);

    public static String PRODUCT_NAME;
    public  void login() {
        waitClicableClick(FIND_LOGIN);
        waitClicableClick(LOGIN_BUTTON);
        waitBySeconds(2);
        waitVisibilitySendKey(EMAIL, USER_NAME);
        waitBySeconds(2);
        waitVisibilitySendKey(PASSWORD, MY_PASSWORD);
        waitBySeconds(3);
        waitClicableClick(SUBMIT_BUTTON);
        logger.info("Giriş işlemi başarılı!");

    }
    public  void searchAndSelectProduct() {
        waitBySeconds(2);
        waitClicableClick(SEARCH_AREA);
        waitVisibilitySendKeyEnter(SEARCH,SEARCH_WORD);
        waitClicableClick(SELECT_CATEGORY);
        waitBySeconds(2);
        waitClicableClick(SELECT_SUBCATEGORY);
        WebElement element;
        element = driver.findElement(By.xpath("//div[@class='searchResultSummaryBar-HM2Hk6FnQ2zwnblc0BJb']/div/h1"));
        String elementText = element.getText();
        if (elementText.equalsIgnoreCase(SEARCH_WORD) || elementText.contains(SEARCH_WORD)) {
            System.out.println("Text '"+SEARCH_WORD+"' ile eşleşiyor.");
        } else {
            System.out.println("Text farklı: " + elementText);
        }
        scrollElement(PRODUCT_NUMBER);
        waitBySeconds(4);
        waitVisibilityClick(PRODUCT_NUMBER);

    }

    public void likeAndPopUpControl()
    {

        String originalWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window); // Yeni sekmeye geç
                String newTabUrl = driver.getCurrentUrl(); // Yeni sekmenin URL'sini al
                System.out.println("Yeni sekmenin URL'si: " + newTabUrl);
                break;
            }
        }
        findProductName();
        WebElement element = driver.findElement(By.xpath("//h2[contains(text(),'Ürün Bilgileri')]"));
        scrollToElement(element);
        directClicableClick(LIKE);
        // waitClicableClick(POP_UP);

    }
    public void findProductName(){
        String productName=driver.findElement(By.xpath("//*[@id=\"container\"]/div/main/div/div/div[2]/section[1]/div[2]/div[1]/div[1]/h1")).getText();
        PRODUCT_NAME=productName;
    }
    public void favoritesCheck()
    {
        waitClicableClick(FIND_LOGIN);
        waitClicableClick(MY_FAVORITES);
        if(isProductFound()){
            waitVisibilityClick(ITEM);
        }

    }

    public void addToCart()
    {
        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Kapasite')]"));
        scrollToElement(element);
        waitClicableClick(ADD_TO_CART);
    }

    public void goToBasket()
    {
        waitClicableClick(GO_TO_BASKET);
    }
    public void deleteFromBasket()
    {
        waitClicableClick(DELETE_FROM_BASKET);
        waitBySeconds(2);
        waitClicableClick(DELETE_BUTTON);
    }
    public boolean isProductFound()
    {
        try {
            ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'"+PRODUCT_NAME+"')]"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
