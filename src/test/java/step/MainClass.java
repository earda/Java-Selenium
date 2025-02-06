package step;

import base.MainTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainClass extends MainTest {
    StepImplementation stepImplementation;

    @BeforeTest
    public void beforeTest(){
        stepImplementation = new StepImplementation();
    }


    @Test
    public void testRun() {
        stepImplementation.login();
        stepImplementation.searchAndSelectProduct();
        stepImplementation.likeAndPopUpControl();
        stepImplementation.favoritesCheck();
        stepImplementation.addToCart();
        stepImplementation.goToBasket();
        stepImplementation.deleteFromBasket();
    }
}
