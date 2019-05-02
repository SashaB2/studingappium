package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.NativeGoogleCalcIndexPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class Runner {
    protected AndroidDriver<AndroidElement> driver;
    protected Logger logger;
    protected NativeGoogleCalcIndexPage nativeGoogleCalcIndexPage;

    public Runner() {
        logger = Logger.getLogger(this.getClass());
    }

    @BeforeTest
    public void setUp(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "nexus5emulator");
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        capabilities.setCapability("noReset", "true");

        try{
            logger.info("Init DRIVER");
            driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            logger.info("DRIVER has been initialized");
        }catch (MalformedURLException e){
            System.out.println(e.getMessage());
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        nativeGoogleCalcIndexPage = new NativeGoogleCalcIndexPage(driver);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
