package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.data.Number;

public class NativeGoogleCalcIndexPage extends BasePage{
    public NativeGoogleCalcIndexPage(AndroidDriver driver) {
        super(driver);
    }

    //number
    private WebElement getNumberButton(int number) {
        return driver.findElementById("com.android.calculator2:id/digit_" + number);
    }

    public void typeMultipleNumber(double number){
        String numberToString = String.valueOf(number);

        for (int i = 0; i < numberToString.length(); i++) {
            Character sign = numberToString.charAt(i);
            if(Character.isDigit(sign))
                getNumberButton(Integer.valueOf(Character.toString(sign))).click();
            else if(sign.equals('-'))
                clickMinusSign();
            else
                clickPointButton();
        }
    }

    @FindBy(id = "com.android.calculator2:id/op_add")
    private WebElement plusSignButton;

    @FindBy(id = "com.android.calculator2:id/op_sub")
    private WebElement subtractSignButton;

    @FindBy(id = "com.android.calculator2:id/op_mul")
    private WebElement multiplySignButton;

    @FindBy(id = "com.android.calculator2:id/op_div")
    private WebElement dividedSignButton;

    @FindBy(id = "com.android.calculator2:id/dec_point")
    private WebElement pointSignButton;

    @FindBy(id = "com.android.calculator2:id/clr")
    private WebElement clearButton;

    @FindBy(id = "com.android.calculator2:id/del")
    private WebElement deleteButton;

    @FindBy(id = "com.android.calculator2:id/result")
    private WebElement resultField;

    @FindBy(id = "com.android.calculator2:id/eq")
    private WebElement equalButton;

    public void typeNumber(Number number){
        getNumberButton(number.number).click();
    }

    public void clickPlusSign(){
        plusSignButton.click();
    }

    public void clickMinusSign(){
        subtractSignButton.click();
    }

    public void clickMultiplyButton(){
        multiplySignButton.click();
    }

    public void clickDividedButton(){
        dividedSignButton.click();
    }

    public void clickClearButton(){
        clearButton.click();
    }

    public void clickDeleteButton(){
        deleteButton.click();
    }

    public void clickPointButton(){
        pointSignButton.click();
    }

    public void clickEqualButton(){
        equalButton.click();
    }

    public String getValueFromResultField(){
        return resultField.getText();
    }

}
