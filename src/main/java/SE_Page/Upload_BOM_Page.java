package SE_Page;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;

public class Upload_BOM_Page {
    private final WebDriver driver;

    public Upload_BOM_Page(WebDriver driver) {
        this.driver = driver;
    }

    public By Next = By.xpath("//body/div[@id='DivUploadBOM']/div[1]/div[1]/div[1]/div[2]/div[1]/button[1]");
    public By MPN = By.xpath("//*[@id=\"bommapUL\"]/li[1]/a");
    public By Select_BOM_Folder = By.xpath("//*[@id=\"selectedFolderName\"]");
    public By Supplier = By.xpath("//*[@id=\"bommapUL\"]/li[2]/a");
    public By Finish_Btn = By.id("btnSaveBom");
    public By Selection = By.xpath("//thead/tr[1]/td[2]");
    public By Next_Step = By.xpath("//*[@id=\"DivUploadBomMapCols\"]/div[1]/div[3]/div/button[2]");
    public By Mapped_IPN = By.xpath("//*[@id=\"bommapUL\"]/li[4]/a");
    public By Selected_Folder = By.id("37753_anchor");
    public By Column2 = By.xpath("//*[@id=\"DivUploadBomMapCols\"]/div[3]/table/thead/tr/td[3]");

    public void Z2D_Click_Next() {
        boolean Intercepted = true;
        while (Intercepted) {
            try {
                ElementActions.click(driver, Next);
                Intercepted = false;
            } catch (ElementNotInteractableException e) {
                Intercepted = true;
            }
        }
    }

    public void Z2D_Click_Next_Visibility() {
        ElementActions.waitForElementToBePresent(driver, Next, 5, true);
    }

    public void Z2D_Select_Type() {
        ElementActions.click(driver, Selection);
    }

    public void Z2D_Supplier_Selection() {
        ElementActions.click(driver, Supplier);
    }

    public void Z2D_MPN_Select() {
        ElementActions.click(driver, MPN);
    }

    public void Z2D_Second_Step() {
        ElementActions.click(driver, Next_Step);
    }

    public void Z2D_Select_Folder() {
        ElementActions.click(driver, Select_BOM_Folder);
    }

    public void Z2D_Selected_Folder() {
        ElementActions.click(driver, Selected_Folder);
    }

    public void Z2D_Finish() {
        ElementActions.click(driver, Finish_Btn);
    }

    public void Z2D_Open_Column() {
        ElementActions.click(driver, Column2);
    }

    public void Z2D_Mapped_IPN_to_be_Clickable() {
        ElementActions.waitForElementToBePresent(driver, Mapped_IPN, 5, true);
    }

    public void Z2D_Mapped_IPN() {
        ElementActions.click(driver, Mapped_IPN);
    }

    public void Z2D_Next_Step_to_be_Clickable() {
        ElementActions.waitForElementToBePresent(driver, Next_Step, 5, true);
    }

    public void Z2D_Wait_Disappear_Z2Data_Spinner_0() throws InterruptedException {
        int count = 0;
        while ((driver.findElements(By.xpath("//*[@id=\"progressDiv\"]/div/div/div[2]")).size() != 0 && count < 40)) {
            Thread.sleep(700);
            count++;
        }
    }

}