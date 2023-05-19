package pearlymarket.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    public static WebDriver driver;



    public static WebDriver getdriver(){

        if(driver==null) {
           switch (ConfigReader.getProperty("browser")){

               case "chrome":
                   WebDriverManager.chromedriver().setup();
                   driver=new ChromeDriver();
                   break;
               case "edge":
                   WebDriverManager.edgedriver().setup();
                   driver=new EdgeDriver();
                   break;
               case "firefox":
                   WebDriverManager.firefoxdriver().setup();
                   driver=new FirefoxDriver();
                   break;

           }

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        return driver;
    }


    public static void closeDriver(){

        if (driver!=null){

            driver.close();
            driver=null;
        }


    }
    public static void quitDriver(){

        if(driver!=null){
            driver.quit();
            driver=null;

        }

    }


























}
