package src.tests;

import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.android.library.AndroidWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import src.core.utils.GetProperty;

import java.net.URL;

public class Hooks {

    public AndroidDriver driver = null;
    GetProperty property = new GetProperty();

    @BeforeClass
    public void setUp() throws Exception {
        try {
            String device = property.getConfProperties("DEVICE");

            if (device.equals("ANDROID")) {

                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("appium:automationName", "UIAutomator2");
                capabilities.setCapability("appium:platformVersion", "9");
                capabilities.setCapability("appium:deviceName", "Android Emulator");
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("appium:app", System.getProperty("user.dir") + "/apps/app-debug.apk");
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);

            }else if (device.equals("IOS")){
                //IOS DRIVER
            }

        }catch(Exception e){
            System.out.println("HOOKS - General Exception " + e);
        }
    }

    @AfterClass
    public void after() {
        try{
           driver.quit();

        }catch(Exception e){
            System.out.println("HOOKS - General Exception " + e);
        }
    }
}
