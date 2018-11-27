package mytest.example.au.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by pc on 10/12/17.
 */
public class Communication {

    private static WebDriver driver = chooseTrueDriver();

    public static WebDriver getDriver() {
        return driver;
    }

    public static void implicitWaitId(String idName){
        WebDriverWait wait = new WebDriverWait(getDriver(),600);
        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.id(idName))));
    }

    public static void implicitWaitIdInvisible(String idName){
        WebDriverWait wait = new WebDriverWait(getDriver(),600);
        wait.until(ExpectedConditions.invisibilityOf(getDriver().findElement(By.id(idName))));
    }

    public static void implicitWaitXpath(String xpath){
        WebDriverWait wait = new WebDriverWait(getDriver(),600);
        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath(xpath))));
    }

    public static void implicitWaitXpathInvisibel(String xpath){
        WebDriverWait wait = new WebDriverWait(getDriver(),600);
        wait.until(ExpectedConditions.invisibilityOf(getDriver().findElement(By.xpath(xpath))));
    }

    public boolean navigatedToWebSite( String url , String verificationElementId){
        getDriver().navigate().to(url);
        implicitWaitId(verificationElementId);
        if(getDriver().findElement(By.id(verificationElementId)) != null)
            return true;
        else
            return false;
    }


    private static WebDriver chooseTrueDriver() {
        switch (System.getProperty("os.name")){
            case "Linux":
                setProperties("/Drivers/chromedriver_linux");
                return new ChromeDriver();
            case "Windows 7":
                setProperties("/Drivers/chromedriver.exe");
                return new ChromeDriver();
            case "Windows 10":
                setProperties("/Drivers/chromedriver.exe");
                return new ChromeDriver();
            case "Mac OS X":
                setProperties("/Drivers/chromedriver_mac");
                return new ChromeDriver();
            default:
                return new ChromeDriver();
        }
    }

    private static void setProperties(String fileName){
        String driverPath = Communication.class.getResource(fileName).getPath().replaceAll("%20", " ");
        System.setProperty("webdriver.chrome.driver" , driverPath);
    }
}
