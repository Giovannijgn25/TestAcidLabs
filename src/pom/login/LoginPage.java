package src.pom.login;

import org.openqa.selenium.By;
import org.openqa.selenium.android.AndroidDriver;
import src.core.helpers.ClickHelpers;
import src.core.helpers.SendKeyHelpers;

public class LoginPage {

    ClickHelpers click = new ClickHelpers();
    SendKeyHelpers write = new SendKeyHelpers();

    public By btnContinueToLogin(){
        return By.id("btnContinueToLogin");
    }
    public By inputEmail(){
        return By.id("formBasicEmail");
    }
    public By inputPassword(){
        return By.id("formBasicPassword-Password");
    }
    public By btnLogin(){
        return By.id("login");
    }
    public By lblErrorEmail(){ return By.id("errorEmailMensaje"); }
    public By lblErrorPassword(){
        return By.id("errorClaveMensaje");
    }


    public void login(AndroidDriver driver, String email, String password){

        click.click(driver, btnContinueToLogin());
        write.write(driver, inputEmail(), email);
        write.write(driver, inputPassword(), password);
        click.click(driver, btnLogin());
    }
}
