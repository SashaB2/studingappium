package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class FirstTest {

    private Logger logger;

    public FirstTest() {
        logger = Logger.getLogger(this.getClass());
    }

    @Test
    public void firstTest(){
        AndroidDriver<AndroidElement> driver = null;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "nexus5emulator");
        capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/7.2 ApiDemos-debug.apk.apk");

        try{
            driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.quit();
        }catch (MalformedURLException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void toggleOnOff() throws InterruptedException {
            AndroidDriver<AndroidElement> driver = null;
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "nexus5emulator");
            capabilities.setCapability("appPackage", "com.android.settings");
            capabilities.setCapability("appActivity", "com.android.settings.Settings");
            capabilities.setCapability("noReset", "true");

            try{
                logger.info("Init DRIVER");
                driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                logger.info("DRIVER has been initialized");
            }catch (MalformedURLException e){
                System.out.println(e.getMessage());
            }

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.findElementByXPath("//android.widget.TextView[@text='More']").click();
            Thread.sleep(1000);
            AndroidElement airplainMode = driver.findElementById("android:id/switch_widget");
            airplainMode.click();
            Thread.sleep(1000);
            Assert.assertEquals("true", airplainMode.getAttribute("checked"));
    }
}
