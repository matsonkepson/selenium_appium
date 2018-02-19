import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class CalcTests {

    //WebDriver driver;

    private static AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException, InterruptedException {
        // Created object of DesiredCapabilities class.
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Set android deviceName desired capability. Set your device name.
        capabilities.setCapability("deviceName", "test_genymotion");

        // Set BROWSER_NAME desired capability. It's Android in our case here.
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");

        // Set android VERSION desired capability. Set your mobile device's OS version.
        //capabilities.setCapability(CapabilityType.VERSION, "6.0.0");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"6.0.0");

        // Set android platformName desired capability. It's Android in our case here.
        capabilities.setCapability("platformName","Android");

        // Set android appPackage desired capability. It is
        // com.android.calculator2 for calculator application.
        // Set your application's appPackage if you are using any other app.
        capabilities.setCapability("appPackage", "com.android.calculator2");

        // Set android appActivity desired capability. It is
        // com.android.calculator2.Calculator for calculator application.
        // Set your application's appPackage if you are using any other app.
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        capabilities.setCapability("waitForAppScript","$.delay(100); true;");

        // Created object of RemoteWebDriver will all set capabilities.
        // Set appium server address and port number in URL string.
        // It will launch calculator app in android device.

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


    }

    @Test
    public void testFirstCalculator() {


        // Click on DELETE/CLR button to clear result text box before running test.
        //driver.findElements(By.xpath("//android.widget.Button")).get(0).click();
        //driver.findElements(By.xpath("//android.widget.Button")).get().click();

        // Click on number 2 button.
        driver.findElement(By.id("com.android.calculator2:id/digit_5")).click();
        driver.findElement(By.id("com.android.calculator2:id/op_add")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_5")).click();
        driver.findElement(By.id("com.android.calculator2:id/eq")).click();


    }

    @After
    public void End() {

        driver.quit();
    }
}
