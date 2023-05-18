package src.tests.login;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import src.core.helpers.AssertHelpers;
import src.core.helpers.ClickHelpers;
import src.core.utils.ReadExcelFile;
import src.pom.home.HomePage;
import src.pom.login.LoginPage;
import src.tests.Hooks;

public class LoginCorrecto extends Hooks {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    ClickHelpers click = new ClickHelpers();
    AssertHelpers asserts = new AssertHelpers();
    ReadExcelFile readFile = new ReadExcelFile();

    @Test(dataProvider="Login")
    public void A820_LoginSuccessful(String email, String password, String tabName) {

        //login
        loginPage.login(this.driver, email, password);

        //Assert validation
        asserts.assertEquals(this.driver, homePage.btnTab(), tabName);
    }

    @DataProvider
    public Object[][] Login() throws Exception{

        Object[][] testObjArray = readFile.getTableArray(System.getProperty("user.dir") + "/src/data/AcidLabs.xlsx.xlsx","IngresoCorrecto");
        return (testObjArray);

    }
}