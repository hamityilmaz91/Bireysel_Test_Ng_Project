package pearlymarket.tests.US09_Vendor_register;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pearlymarket.utilities.Driver;
import pearlymarket.utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class Remziye_abla {


    @Test
    public void test() {

        // kullanici siteye gider
        Driver.getdriver().get("https://www.pearlymarket.com");
        // sign in e tiklar
        Driver.getdriver().findElement(By.xpath("//span[text()='Sign In']")).click();
        // mail adresini girer
        Driver.getdriver().findElement(By.xpath("//input[@id='username']")).sendKeys("abdulrehman.jaice@fullangle.org");
        // sifre girer
        Driver.getdriver().findElement(By.xpath("//input[@id='password']")).sendKeys("Ab12345");
        // sign in butonuna tiklar
        Driver.getdriver().findElement(By.xpath("(//button[@type='submit'])[1]")).click();
        // 3 saniye beklesin
        ReusableMethods.bekle(3);
        //JS  executer kullanarak  sayfanin asagisinda my account linkine tiklar
        WebElement myaccount =  Driver.getdriver().findElement(By.xpath("//a[text()='My Account']"));
        ReusableMethods.click(myaccount);
        //Store managera tiklanir
        Driver.getdriver().findElement(By.xpath("//*[text()='Store Manager']")).click();
        // Product linkine tiklayiniz
        WebElement produkt=Driver.getdriver().findElement(By.xpath("(//span[@class='text'])[4]"));
        ReusableMethods.click(produkt);
        // Add new butonuna tiklanir
        WebElement addnew =Driver.getdriver().findElement(By.xpath("(//*[text()='Add New'])[1]"));
        ReusableMethods.click(addnew);
        // dropdown locate edilir
        WebElement ddm= Driver.getdriver().findElement(By.xpath("//select[@id='product_type']"));
        Select select =new Select(ddm);
        List<WebElement> Webelement_menu=select.getOptions();
        ArrayList<String> String_menu= new ArrayList<>();
        for (int i = 0; i < Webelement_menu.size(); i++) {
                String_menu.add(Webelement_menu.get(i).getText());

        }
        System.out.println("**********************************************");
        System.out.println(String_menu);
       Assert.assertTrue(String_menu.contains("Simple Product"));
       Assert.assertTrue(String_menu.contains("Variable Product"));
       Assert.assertTrue(String_menu.contains("Grouped Product"));
       Assert.assertTrue(String_menu.contains("External/Affiliate Product"));
       //select.getFirstSelectedOption().getText();
       //Simple Product, Variable Product, Grouped Product, External - Affiliate Product seçenekleri olmalı

        // Short decription iframe icerisine girmek ve yazi yazmak
        WebElement birinci_iframe =Driver.getdriver().findElement(By.xpath("//iframe[@id='excerpt_ifr']"));
       Driver.getdriver().switchTo().frame(birinci_iframe);
       Driver.getdriver().findElement(By.xpath("//body[@id='tinymce']")).sendKeys("birinci yazi");
       //Driver.getdriver().findElement(By.xpath("//body[@data-id='excerpt']")).sendKeys("dgsfgdgshfhdsgsdabbvjsadb");

        // Description  iframe icerisne girmek ve yazi yazmak
        Driver.getdriver().switchTo().parentFrame();
        WebElement ikinci_iframe= Driver.getdriver().findElement(By.xpath("//iframe[@id='description_ifr']"));

        Driver.getdriver().switchTo().frame(ikinci_iframe);
        Driver.getdriver().findElement(By.xpath("//body[@id='tinymce']")).sendKeys("ikinci yazi");



       /*
       // Driver.getdriver().findElement(By.xpath("//body[@data-id='description']")).sendKeys("dfkjgdghjgflakvhadlkfj");
        Driver.getdriver().switchTo().parentFrame();

        //<input type="checkbox" data-super_parent="229" class="wcfm-checkbox checklist_type_product_cat " name="product_cats[]" value="229" data-required="1" data-required_message="Product cat: This field is required.">
        //<input type="checkbox" data-super_parent="428" class="wcfm-checkbox checklist_type_product_cat " name="product_cats[]" value="428" data-required="1" data-required_message="Product cat: This field is required.">


       List<WebElement> kutucuk_listesi= Driver.getdriver().findElements(By.xpath("//div[@class='wcfm_product_manager_cats_checklist_fields']//input"));
        for (WebElement w : kutucuk_listesi) {
                    w.click();
                }
        12	Categories yazisini görür.
        13	Categories ' in altinda acilan menudeki kutucuklari secer
        14	Bütün kutulari tek tek secer
        15	Bütün kutularin  secilebildigini görür

        */

      //JavascriptExecutor js= (JavascriptExecutor) Driver.getdriver();

      //  WebElement elemt = (WebElement) js.executeScript("return document.getElementById('......')");

        // kullanici categories yazisini görür

        // 1. deneme text ile calismadi.
        //  WebElement categories_yazisi = Driver.getdriver().findElement(By.xpath("(//*[text()='Categories'])[1]"));

        // 2. deneme Bir ust class bir locate  ile ulasmaya caliyorum    ......

       //WebElement categories= Driver.getdriver().findElement(By.xpath("(//p[@class='wcfm_title wcfm_full_ele'])[1]"));
        //categories.getText();

        //  3. deneme bir üst class tan daha son deneme          ......//div[@class='wcfm_product_manager_cats_checklist_fields']

      //  WebElement categories=  Driver.getdriver().findElement(By.xpath("//div[@class='wcfm_product_manager_cats_checklist_fields']"));
        //System.out.println(categories.getText());




        JavascriptExecutor js= (JavascriptExecutor) Driver.getdriver();

       // WebElement element = (WebElement) (js.executeScript("return document.evaluate(\"xpath_expression\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue");

      //  WebElement element = (WebElement) (js.executeScript("return document.evaluate(\"(//input[@type='checkbox'])[10]\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue"));
        //Reasubale_metods .click(element);

        // WebElement element = (WebElement) (js.executeScript("return document.querySelector(\"css_selector\")");


       // WebElement element = (WebElement) (js.executeScript("return document.getElementById(\"element_id\")");
      //  WebElement element1 = (WebElement) (js.executeScript("return document.getElementById(\"is_virtual\")"));
        //Reasubale_metods .click(element1);


        //WebElement element = (WebElement) (js.executeScript("return document.getElementsByClassName(\"element_class\")[0]");
      //  WebElement element2 = (WebElement) (js.executeScript("return document.getElementsByClassName(\"wcfm-checkbox wcfm_ele wcfm_half_ele_checkbox simple booking non-variable-subscription non-job_package non-resume_package non-redq_rental non-accommodation-booking non-pw-gift-card\")[0]"));
        //Reasubale_metods .click(element2);


        // WebElement element = (WebElement) (js.executeScript("return document.querySelector(\"[attribute_name='attribute_value']\")");

        // WebElement element3 = (WebElement) (js.executeScript("return document.querySelector(\"[value='enable']\")"));
        //Reasubale_metods .click(element3);


        //id="is_virtual"
        // xpath =(//input[@type='checkbox'])[10]


        //<input type="checkbox"
        // id="is_virtual"
        // name="is_virtual"
        // class="wcfm-checkbox wcfm_ele wcfm_half_ele_checkbox simple booking non-variable-subscription non-job_package non-resume_package non-redq_rental non-accommodation-booking non-pw-gift-card"
        // value="enable">

        //List<WebElement> büyüklist=Driver.getdriver().findElements(By.xpath("//input[@type='checkbox']"));

        //System.out.println(büyüklist.size());

/*
 public static void sendKeysJS(WebElement element, String text) {
        JavascriptExecutor js = (JavascriptExecutor) techproed.utilities.Driver.getDriver();
        js.executeScript("arguments[0].value='" + text + "'", element);
    }

    //JS SendAttributeValue
    public static void sendAttributeJS(WebElement element, String text) {
        JavascriptExecutor js = (JavascriptExecutor) techproed.utilities.Driver.getDriver();
        js.executeScript("arguments[0].setAttribute('value','" + text + "')", element);
    }

    //JS GetAttributeValue
    public static void getValueByJS(String id, String attributeName) {
        JavascriptExecutor js = (JavascriptExecutor) techproed.utilities.Driver.getDriver();
        String attribute_Value = (String) js.executeScript("return document.getElementById('" + id + "')." + attributeName);
        System.out.println("Attribute Value: = " + attribute_Value);
    }







 */
      WebElement element = Driver.getdriver().findElement(By.xpath("//input[@id='regular_price']"));
        js.executeScript("arguments[0].setAttribute('value','" + "123" + "')", element);
    }   //metod


}//class

