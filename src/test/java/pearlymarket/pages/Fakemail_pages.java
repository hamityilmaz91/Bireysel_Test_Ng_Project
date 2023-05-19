package pearlymarket.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pearlymarket.utilities.Driver;

public class Fakemail_pages {

    public Fakemail_pages(){

        PageFactory.initElements(Driver.getdriver(),this);

    }




    @FindBy(xpath = "//iframe[@id='google_esf']")
    public WebElement iframe;

    @FindBy(xpath = "//span[@id='email']")
    public WebElement email_kutucugu;

    @FindBy(xpath = "//*[@class='glyphicon glyphicon-envelope'][1]")
    public WebElement gelen_sifre_mektubu;

    @FindBy(xpath = "(//iframe)[2]")
    public WebElement gelen_mesaj_icin_ifame;

    @FindBy(xpath = "//div[@id='body_content_inner']")
    public WebElement gelen_sifre_mesaji;








}
