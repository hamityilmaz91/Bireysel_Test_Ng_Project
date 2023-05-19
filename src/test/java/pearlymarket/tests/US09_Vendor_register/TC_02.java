package pearlymarket.tests.US09_Vendor_register;

import org.testng.Assert;
import org.testng.annotations.Test;
import pearlymarket.pages.Home_page_hamit;
import pearlymarket.utilities.ConfigReader;
import pearlymarket.utilities.Driver;
import pearlymarket.utilities.ReusableMethods;

public class TC_02 {


     /*
      Kullanici ana sayfaya gider       	https://pearlymarket.com/
      Kullanici sag ust kösede register yazisini görür
      Kullanici sag üst kösedeki register yazisina tiklar
      "Kullanici acilan pencerenin en altinda
      Became  Vendor yazisina tiklar "
      Kullanici Vendor Registration sayfasina gider
      Kullanici e mail kutucuguna tiklar
      Kullanici e mail kutucuguna valid bir deger girer	xaden.odie@fullangle.org

     */
    Home_page_hamit home_pagehamit =new Home_page_hamit();

    @Test
    public void TC_02(){

        //    Kullanici ana sayfaya gider
        Driver.getdriver().get(ConfigReader.getProperty("pearlymarket_url"));

        //  Kullanici sag ust kösede register yazisini görür
        Boolean register_goruluyor= home_pagehamit.register.isDisplayed();
        System.out.println(register_goruluyor);
        Assert.assertTrue(register_goruluyor);
        /*
        2.YOL
        Assert.assertTrue(Reasubale_metods.element_gorunuyor_mu(home_pages.register));
        */


        //Kullanici sag üst kösedeki register yazisina tiklar
        home_pagehamit.register.click();

        //Kullanici acilan pencerenin en altinda  "Became  Vendor "yazisina tiklar
        ReusableMethods.bekle(2);
        home_pagehamit.Became_vendor.click();

        //Kullanici Vendor Registration sayfasina gider
        Assert.assertTrue(home_pagehamit.Vendor_registratio_yazisi.isDisplayed());
        System.out.println("Tc 1 basari ile noktalandi ");

        //Kullanici e mail kutucuguna tiklar
        Assert.assertTrue(home_pagehamit.email_kutucugu.isEnabled());

        // Kullanici e mail kutucuguna valid bir deger girer	xaden.odie@fullangle.org
        home_pagehamit.email_kutucugu.sendKeys("xaden.odie@fullangle.org");


    }//metod
}
