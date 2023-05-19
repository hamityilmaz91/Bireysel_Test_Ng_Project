package pearlymarket.tests.US09_Vendor_register;

import org.testng.Assert;
import org.testng.annotations.Test;
import pearlymarket.pages.Fakemail_pages;
import pearlymarket.pages.Home_page_hamit;
import pearlymarket.utilities.ConfigReader;
import pearlymarket.utilities.Driver;
import pearlymarket.utilities.ReusableMethods;

public class TC_11 {
             /*
         Kullanici ana sayfaya gider
         Kullanici sag ust kösede register yazisini görür
         Kullanici sag üst kösedeki register yazisina tiklar
         Kullanici acilan pencerenin en altinda  Became  Vendor yazisina tiklar "
         Kullanici Vendor Registration sayfasina gider
         Kullanici e mail kutucuguna tiklar
         Kullanici e mail kutucuguna daha önceden girilen valid bir deger girer         //xaden.odie@fullangle.org
         Kullanici verifcation text kutusuna tiklar
         Kullanici Verification code kutucuguna "111111" girer
         Kullanci password kutucuguna tiklar
         Kullanici buyuk harf kucuk haf rakam iceren  invalid bir sifre girer
         Kullanci confirm password alanina tiklar
         Kullanici password alanina sifreyi tekrar girer
         Kullanici  register butonuna tiklar
         Kullanici ekranda "This Email already exists. Please login to the site and apply as vendor." hata mesajini görür
     */

    Home_page_hamit home_pagehamit = new Home_page_hamit();
    Fakemail_pages fakemail_pages = new Fakemail_pages();


    @Test
    public void TC_11(){

        //Kullanici ana sayfaya gider
        Driver.getdriver().get(ConfigReader.getProperty("pearlymarket_url"));


        //  Kullanici sag ust kösede register yazisini görür
        Boolean register_goruluyor = home_pagehamit.register.isDisplayed();
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

        // Kullanici e mail kutucuguna valid bir deger girer            ///////xaden.odie@fullangle.org
        home_pagehamit.email_kutucugu.sendKeys("xaden.odie@fullangle.org");


        // Kullanici verifcation text kutusuna tiklar
        home_pagehamit.verification_code_kutusu.click();


       // Kullanici Verification code kutucuguna "111111" girer

        home_pagehamit.verification_code_kutusu.sendKeys("111111");

        // Kullanci password kutucuguna tiklar
        ReusableMethods.click(home_pagehamit.password_kutucugu);
        // PASSWORD KUTUCUGU JAVA SCRIPT KODLARI ILE YAZILMIS : BUNDAN DOLAYI REASUBALE METODDAKI CLICK ILE  CALISTI


        // Kullanici buyuk harf kucuk haf rakam iceren  invalid bir sifre girer    ///////Ab12345

        home_pagehamit.password_kutucugu.sendKeys("Ab12345");


        //  Kullanci confirm password alanina tiklar
        ReusableMethods.click(home_pagehamit.confirm_password_kutucugu);

        // Kullanici confirm password alanina sifreyi tekrar girer                                    ///////////////Ab12345
        home_pagehamit.confirm_password_kutucugu.sendKeys("Ab12345");

        // Kullanici  register butonuna tiklar
        ReusableMethods.click(home_pagehamit.register_butonu);

        // uyari yazisi icin gerekli süre beklenir
        ReusableMethods.gorunene_kadar_bekle(home_pagehamit.bu_mail_adresi_kayitli_yazisi);

        //Kullanici ekranda "This Email already exists. Please login to the site and apply as vendor." hata mesajini görür
        Assert.assertTrue(home_pagehamit.bu_mail_adresi_kayitli_yazisi.getText().contains("This Email already exists"));

    }


}

