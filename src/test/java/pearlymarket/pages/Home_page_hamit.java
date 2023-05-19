package pearlymarket.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pearlymarket.utilities.Driver;

public class Home_page_hamit {


    public Home_page_hamit() {
        PageFactory.initElements(Driver.getdriver(), this);

    }

    @FindBy(xpath = "//a[@class='register inline-type']")
    public WebElement register;

    @FindBy(xpath = "//*[text()='Become a Vendor']")
    public WebElement Became_vendor;

    @FindBy(xpath = "(//*[text()='Vendor Registration'])[1]")
    public WebElement Vendor_registratio_yazisi;

    @FindBy(xpath = "//input[@id='user_email']")
    public WebElement email_kutucugu;

    @FindBy(xpath = "//input[@name='wcfm_email_verified_input']")
    public WebElement verification_code_kutusu;

    @FindBy(xpath = "//div[@class='wcfm-message email_verification_message wcfm-success']")
    public WebElement kod_gonderildi_yazisi;

    @FindBy(xpath = "//input[@id='passoword']")
    public WebElement password_kutucugu;


    @FindBy(xpath = "//input[@id='confirm_pwd']")
    public WebElement confirm_password_kutucugu;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement register_butonu;

    @FindBy(xpath = "//*[text()='Welcome to Pearly Market!']")
    public WebElement hosgeldiniz_yazisi;

    @FindBy(xpath = "//div[@class='wcfm-message wcfm-error']")
    public WebElement bu_mail_adresi_kayitli_yazisi;

    @FindBy(xpath = "//div[@id='password_strength']")
    public WebElement too_short_yazisi;

    @FindBy(xpath = "//div[@id='password_strength']")
    public WebElement week_yazisi;

    @FindBy(xpath = "//div[@id='password_strength']")
    public WebElement good_yazisi;

    @FindBy(xpath = "//div[@id='password_strength']")
    public WebElement strong_yazisi;

    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement sign_in;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement sign_in_email_kutucugu;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement sign_in_password_kutucugu;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement sign_in_sign_in;

    @FindBy(xpath = "//*[text()='Sign Out']")
    public WebElement sign_out;

    @FindBy(xpath = "(//*[text()='My Account'])[2]")
    public WebElement myaccount;





}//class
