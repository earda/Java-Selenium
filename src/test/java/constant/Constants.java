package constant;

import org.openqa.selenium.By;

public class Constants {

    public static final By FIND_LOGIN = By.xpath("//*[@id='myAccount']");
    public static final By LOGIN_BUTTON = By.xpath("//*[@id='login']");
    public static final By EMAIL = By.id("txtUserName");
    public static final String USER_NAME = "ea7481017@gmail.com";
    public static final By PASSWORD = By.id("txtPassword");
    public static final String MY_PASSWORD = "**********";
    public static final By SUBMIT_BUTTON = By.id("btnLogin");
    public static final By MY_FAVORITES = By.xpath("//*[@id=\"myAccount\"]/div/div/ul/li[7]/a");
    public static final By SEARCH = By.xpath("//div[@class='searchBarContent-xdmlXT7UifVmw5n9e2a6']/div/div/input");
    public static final By SEARCH_AREA = By.xpath("/html/body/div[1]/div/div[4]/div[5]/div/div/div/div[1]/div[2]/div[2]/div/div[2]/div/div/div/div/div/div");
    public static final By SELECT_CATEGORY = By.xpath("//div[@data-test-id='tree-container']/child::div//div[text()='Telefon']");
    public static final By SELECT_SUBCATEGORY = By.xpath("//*[text()='Cep Telefonu']");
    public static final String SEARCH_WORD = "samsung";
    public static final By PRODUCT_NUMBER = By.xpath("//*[@id='i40']/div");
    public static final By LIKE = By.xpath("//section[1]/div[2]/div[8]/div/div/div[2]/div/div/div/div/div[1]");
    public static final By POP_UP = By.xpath("/html/body/div[8]/div[1]/div/div[2]/div[2]/a");
    public static final By ITEM = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/div[7]/div[3]/div/ul/div[1]/div/div/a");
    public static final By ADD_TO_CART = By.xpath("/html/body/div[2]/div/main/div/div/div[2]/section[1]/div[2]/div[8]/button");
    public static final By GO_TO_BASKET = By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/div/div/div/div/div/div/div[1]/div/div[1]/div/div[2]/button[1]");
    public static final By DELETE_FROM_BASKET = By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/div[2]/section/section/div[2]/ul/li/div[1]/div[2]/div[2]/div[2]/div[1]/div/a[1]");
    public static final By DELETE_BUTTON = By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/div[2]/section/section/div[2]/ul/li/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/div/div/div/div/button[2]");
}
