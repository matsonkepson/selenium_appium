import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;



public class SimpleAppiumProgram {


    private static AndroidDriver driver;

    @Test

    public static void main(String []arg) throws MalformedURLException, InterruptedException{


        // apk file localtion
        File appDir = new File("/home/mati/Downloads");
        File app = new File(appDir, "selendroid-test-app-0.17.0.apk");

        //// Created object of DesiredCapabilities class.
        DesiredCapabilities capabilities=new DesiredCapabilities();

        // Set android deviceName desired capability. Set genymotion emulator name.
        // You can also make this with regular device try to run via shell
        // $ adb devices
        capabilities.setCapability("deviceName", "192.168.56.101:5555");

        // Set android platformName desired capability. It's Android in our case here.
        capabilities.setCapability("platformName", "Android");

        // Set android VERSION desired capability. Set genymotion emulator (or physical device) OS version.
        capabilities.setCapability(CapabilityType.VERSION, "7.1.0");

        // Set BROWSER_NAME desired capability. It's Android in our case here.
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");

        //this Flag is used when we don't want to reset app state between sessions
        //(Android: don’t uninstall app before new session). Its default Value is False
        capabilities.setCapability("noReset","true");

        //Do not remove the app after the session is complete. Default false.
        capabilities.setCapability("fullReset","false");

        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

        // wait 5 seconds and open app
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //do some tests
        driver.findElement(By.id("io.selendroid.testapp:id/my_text_field")).sendKeys("Servus Oida! \nIch bin deine papa :)");
        driver.findElement(By.id("io.selendroid.testapp:id/buttonTest")).click();

        // sleep 5 and close the app
        Thread.sleep(5000);
        driver.findElement(By.id("android:id/button1")).click();

        // kill driver and go to homescreen
        driver.quit();



    }
}