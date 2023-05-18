package src.core.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.android.AndroidDriver;

public class SendKeyHelpers {

    WaitHelpers wait = new WaitHelpers();

    public void write(AndroidDriver driver, By element, String value){
        try{
            wait.waitClickeable(driver, element);
            driver.findElement(element).sendKeys(value);

        }catch(Exception e){
            System.out.println("SendKeyHelpers " + e);

        }
    }
}
