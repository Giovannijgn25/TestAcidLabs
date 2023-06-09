package src.core.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.android.AndroidDriver;

public class ClickHelpers {

    WaitHelpers wait = new WaitHelpers();

    public void click(AndroidDriver driver, By element){
        try{
            wait.waitClickeable(driver, element);
            driver.findElement(element).click();

        }catch(Exception e){
            System.out.println("ClickHelpers " + e);

        }
    }
}
