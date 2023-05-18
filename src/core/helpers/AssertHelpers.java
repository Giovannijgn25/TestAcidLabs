package src.core.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.android.AndroidDriver;
import org.testng.Assert;

public class AssertHelpers {

    WaitHelpers wait = new WaitHelpers();

    public void assertEquals(AndroidDriver driver, By element, String expectedText){
        try{
            wait.waitClickeable(driver, element);
            String actualText = driver.findElement(element).getText();
            Assert.assertEquals(actualText, expectedText);
        }catch(Exception e){
            System.out.println("AssertHelpers " + e);

        }
    }
}
