package pearlymarket.tests.US09_Vendor_register;

import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pearlymarket.pages.Fakemail_pages;
import pearlymarket.pages.Home_page_hamit;
import pearlymarket.utilities.ConfigReader;
import pearlymarket.utilities.Driver;
import pearlymarket.utilities.ReusableMethods;

public class TC_04 {
      /*
        Kullanici ana sayfaya gider                                                         //////	https://pearlymarket.com/
        Kullanici sag ust kösede register yazisini görür
        Kullanici sag üst kösedeki register yazisina tiklar
        Kullanici acilan pencerenin en altinda
        Became  Vendor yazisina tiklar "
        Kullanici Vendor Registration sayfasina gider
        Kullanici e mail kutucuguna tiklar
        Kullanici e mail kutucuguna valid bir deger girer                                   /////// ............
        Kullanici verifcation text kutusuna tiklar
        Kullanici Verification text kutusunun altinda
        "Verification code sent to your email: xaden.odie@fullangle.org." yazisini görür"
        "Kullanici mail adresine gelen kodu Verification code kutucuguna girer "	        ////   ........

     */


    Home_page_hamit home_pagehamit = new Home_page_hamit();
    Fakemail_pages fakemail_pages = new Fakemail_pages();

    @Test
    public void TC_04() {


        //   https://www.fakemail.net/ adresine gidilir
        Driver.getdriver().get(ConfigReader.getProperty("fakemail_url"));

        //acilan sayfanin windowhandl degeri alinir
        String fake_mail_sayfasinin_hash_kodu=Driver.getdriver().getWindowHandle();
        System.out.println(fake_mail_sayfasinin_hash_kodu);



        //e mail kutucugundaki mail adresi String maile atanir

        String email = fakemail_pages.email_kutucugu.getText();
        System.out.println(email);

        // yeni bir tab acilir

        Driver.getdriver().switchTo().newWindow(WindowType.TAB);


        //Kullanici ana sayfaya gider
        Driver.getdriver().get(ConfigReader.getProperty("pearlymarket_url"));

        //acilan sayfanin hash kodu alinir
        String pearlymarket_sayfasinin_hash_kodu =Driver.getdriver().getWindowHandle();

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

        // Kullanici e mail kutucuguna valid bir deger girer
        home_pagehamit.email_kutucugu.sendKeys(email);


        // Kullanici verifcation text kutusuna tiklar
        home_pagehamit.verification_code_kutusu.click();
        ReusableMethods.bekle(5);

        //"Kullanici Verification text kutusunun altinda "Verification code sent to your email: xaden.odie@fullangle.org." yazisini görür
        String kod_gonderildi_yazisi = home_pagehamit.kod_gonderildi_yazisi.getText();
        String tamamlama="Verification code sent to your email: "+email+".";
        System.out.println(tamamlama);
        System.out.println(kod_gonderildi_yazisi);
        Assert.assertTrue(kod_gonderildi_yazisi.contains( "Verification code sent to your email:"));



                // "Kullanici mail adresine gelen kodu Verification code kutucuguna girer "	        ////   417696
            ReusableMethods.bekle(4);

            // kodu almak icin tekrar fakemail sitesine gidilir
        Driver.getdriver().switchTo().window(fake_mail_sayfasinin_hash_kodu);
        ReusableMethods.bekle(7);

        //  mailimize gelen sifre mesajina tiklanir
        fakemail_pages.gelen_sifre_mektubu.click();

        // gelen mesaj metinin almak icin iframe e gecis yapilir

        Driver.getdriver().switchTo().frame(fakemail_pages.gelen_mesaj_icin_ifame);

        // acilan mesajdaki sifre alinir
        String dogrulama_kodu=fakemail_pages.gelen_sifre_mesaji.getText();
        System.out.println(dogrulama_kodu);
        System.out.println(dogrulama_kodu.length());

        // gelen mesajdaki kod alinir
        String kullanilacak_rakamlar=fakemail_pages.gelen_sifre_mesaji.getText().replaceAll("[^0-9]","");
        System.out.println("*****************************************************************************");
        System.out.println(kullanilacak_rakamlar);

        // String olan rakamlar integer a cevrilir ve kullanima hazir hale getirilir
         int kullanilacak_rakamlarin_son_hali = Integer.parseInt(kullanilacak_rakamlar);

         // driver parent  frame e alinir
        Driver.getdriver().switchTo().parentFrame();

        // alisveris sitesine tekrar gecilir
        Driver.getdriver().switchTo().window(pearlymarket_sayfasinin_hash_kodu);

        //Verification kode  alanina   kullanicilack integr kod girilir
       //  home_pages.verification_code_kutusu.sendKeys(kullanilacak_rakamlarin_son_hali);

        //Verification kode String rakamlar olarak gönderilir
        home_pagehamit.verification_code_kutusu.sendKeys(kullanilacak_rakamlar);


    }
}
