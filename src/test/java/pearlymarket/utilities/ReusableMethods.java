package pearlymarket.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReusableMethods {




    public static boolean element_gorunuyor_mu(WebElement webElement){

        return webElement.isDisplayed();
    }

    public static void bekle(int saniye){

        try {
            Thread.sleep(1000*saniye);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void gorunene_kadar_bekle(WebElement webElement){

        WebDriverWait wait=new WebDriverWait(Driver.getdriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(webElement));


    }


    public static void click(WebElement webElement){

        try {
            webElement.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) Driver.getdriver();
            js.executeScript("arguments[0].click();", webElement);
        }


    }



















}//class
