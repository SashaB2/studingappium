package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.data.Number;
import utils.Runner;

public class NativeGoogleCalcTest extends Runner {

    @Test
    public void verifySum(){
        logger.info("Start calc sum test");

        nativeGoogleCalcIndexPage.typeNumber(Number.ONE);
        nativeGoogleCalcIndexPage.clickPlusSign();
        nativeGoogleCalcIndexPage.typeNumber(Number.ONE);
        nativeGoogleCalcIndexPage.clickEqualButton();
        Assert.assertEquals(nativeGoogleCalcIndexPage.getValueFromResultField(), "2");
    }

    @DataProvider
    public Object [][] dataForSumMultipleNumber(){
        return new Object[][]{
                {1, 1.1, "2.1"},
                {1.1, 1, "2.1"},
                {1, 0, "1"},
                {-1, 1, "0"},
                {-1, 1.1, "0.1"},
                {0, 0, "0"}
        };
    }

    @Test(dataProvider = "dataForSumMultipleNumber")
    public void sumMultipleNumber(double a, double b, String expected){
        logger.info("Start parametrized calc sum test");

        nativeGoogleCalcIndexPage.typeMultipleNumber(a);
        nativeGoogleCalcIndexPage.clickPlusSign();
        nativeGoogleCalcIndexPage.typeMultipleNumber(b);
        nativeGoogleCalcIndexPage.clickEqualButton();
        Assert.assertEquals(nativeGoogleCalcIndexPage.getValueFromResultField(), expected);
        nativeGoogleCalcIndexPage.clickClearButton();
    }
}
