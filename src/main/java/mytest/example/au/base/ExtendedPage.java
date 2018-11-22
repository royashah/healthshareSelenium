package mytest.example.au.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by pc on 10/13/17.
 */
public abstract class ExtendedPage {

    private WebDriver driver = Communication.getDriver();

    protected void setTextBoxWithId(String id, String value){
        driver.findElement(By.id(id)).sendKeys(value);
    }
    protected void setTextBoxWithXpath(String xpath, String value){
        Communication.implicitWaitXpath(xpath);
        driver.findElement(By.xpath(xpath)).clear();
        driver.findElement(By.xpath(xpath)).sendKeys(value);
    }

    protected void selectWithId(String id){
        driver.findElement(By.id(id)).click();
    }

    protected void selectWithXpath(String xpath){
        Communication.implicitWaitXpath(xpath);
        driver.findElement(By.xpath(xpath)).click();
    }

    protected void selectDropDownList(String id,String value){
        Communication.implicitWaitId(id);
        new Select(driver.findElement(By.id(id))).selectByVisibleText(value);
    }



    public abstract boolean init();

}
