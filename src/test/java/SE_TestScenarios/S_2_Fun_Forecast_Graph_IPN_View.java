package SE_TestScenarios;


import SE_Page.*;
import SE_Page.Forecast_Page;
import com.shaft.gui.browser.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class S_2_Fun_Forecast_Graph_IPN_View   {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void initialize_Global_Objects_and_Navigate() {
        driver = BrowserFactory.getBrowser(BrowserFactory.BrowserType.GOOGLE_CHROME);
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Navigate_To_URL_for_Navigation();
    }

    @Test(description = "TS001 || Login to Z2Data Part Risk", priority = 1)
    public void Login() {
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Z2D_SignIn();
    }

    @Test(description = "TS002 || Validate Forecast tab Table IPN View Check table's data", priority = 2)
    public void ForeCast_Graph_IPN_View() throws InterruptedException {

        Data_Management_Page Data_Management_Obj = new Data_Management_Page(driver);
        Risk_Management_Module Risk_Management_Obj = new Risk_Management_Module(driver);
        Obsolescence_Page Obsolescence_Obj = new Obsolescence_Page(driver);

        Data_Management_Obj.Z2D_Move_to_Forecast_BOM();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Spinner_Zezo_1();
        Risk_Management_Obj.Z2D_Switchers_Pipeline_Clickability();
        Risk_Management_Obj.Z2D_Select_Switcher();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Spinner_Zezo_1();
        String Multi_Source_Filter_Value = driver.findElement(Risk_Management_Obj.Forecast_Ele_First_Filter).getText();
        //System.out.println("Multi_Source_Filter_Value : " + Multi_Source_Filter_Value);
        Risk_Management_Obj.Z2D_Forecast_Click_on_First_Filter();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Spinner_Zezo_1();
        Wait_Text_To_be(driver.findElement(Risk_Management_Obj.Forecast_Ele_Total_Value), Multi_Source_Filter_Value);
        String TotalFilterValue = driver.findElement(Risk_Management_Obj.Forecast_Ele_Total_Value).getText();
        //System.out.println("Total Filter Value : " + TotalFilterValue);
        Assert.assertEquals(TotalFilterValue, Multi_Source_Filter_Value);
        if (TotalFilterValue.equals("0")) {
            System.out.println("No Data for the Selected Filter");
        } else {
            String First_Row_Name = driver.findElement(Risk_Management_Obj.First_Table_Data).getText();
            Risk_Management_Obj.Z2D_Forecast_Click_on_First_Result();
            String Opened_File_Name = driver.findElement(Risk_Management_Obj.Forecast_Ele_File_Name).getText();
            Assert.assertTrue(Opened_File_Name.contains(First_Row_Name), "Opened File is the same as Selected");
        }

        String Single_Source_Filter_Value = driver.findElement(Risk_Management_Obj.Forecast_Ele_Second_Filter).getText();
        //System.out.println("Single_Source_Filter_Value : " + Single_Source_Filter_Value);
        Wait_Element_Clickable(driver.findElement(Risk_Management_Obj.Forecast_Ele_Second_Filter));

        Risk_Management_Obj.Z2D_Forecast_Click_on_Second_Filter();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Spinner_Zezo_1();
        Wait_Text_To_be(driver.findElement(Risk_Management_Obj.Forecast_Ele_Total_Value), Single_Source_Filter_Value);
        String TotalFilterValue2 = driver.findElement(Risk_Management_Obj.Forecast_Ele_Total_Value).getText();
        //System.out.println("Total Filter Value : " + TotalFilterValue2);
        Assert.assertEquals(TotalFilterValue2, Single_Source_Filter_Value);
        if (TotalFilterValue2.equals("0")) {
            System.out.println("No Data for the Selected Filter");
        } else {
            String First_Row_Name = driver.findElement(Risk_Management_Obj.First_Table_Data).getText();
            Risk_Management_Obj.Z2D_Forecast_Click_on_First_Result();
            String Opened_File_Name = driver.findElement(Risk_Management_Obj.Forecast_Ele_File_Name).getText();
            Assert.assertTrue(Opened_File_Name.contains(First_Row_Name), "Opened File is the same as Selected");
        }

        String NA_Source_Filter_Value = driver.findElement(Risk_Management_Obj.Forecast_Ele_Fifth_Filter).getText();
        //System.out.println("NA_Source_Filter_Value : " + NA_Source_Filter_Value);
        Risk_Management_Obj.Z2D_Forecast_Click_on_Fifth_Filter();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Spinner_Zezo_1();
        Wait_Text_To_be(driver.findElement(Risk_Management_Obj.Forecast_Ele_Total_Value), NA_Source_Filter_Value);
        String TotalFilterValue3 = driver.findElement(Risk_Management_Obj.Forecast_Ele_Total_Value).getText();
        //System.out.println("Total Filter Value : " + TotalFilterValue3);
        Assert.assertEquals(TotalFilterValue3, NA_Source_Filter_Value);
        if (TotalFilterValue3.equals("0")) {
            System.out.println("No Data for the Selected Filter");
        } else {
            String First_Row_Name = driver.findElement(Risk_Management_Obj.First_Table_Data).getText();
            Risk_Management_Obj.Z2D_Forecast_Click_on_First_Result();
            String Opened_File_Name = driver.findElement(Risk_Management_Obj.Forecast_Ele_File_Name).getText();
            //System.out.println(Opened_File_Name);
            //System.out.println(First_Row_Name);
            Assert.assertTrue(Opened_File_Name.contains(First_Row_Name), "Opened File is the same as Selected");
            Wait_Element_Visible(driver.findElement(Obsolescence_Obj.Close_Slide));
            Obsolescence_Obj.Z2D_Close_Slide();
        }
    }
    @AfterClass(alwaysRun = true)
    public void TearDown() {
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Tear_Down();
    }
}
