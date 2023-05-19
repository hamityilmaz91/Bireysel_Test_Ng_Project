package pearlymarket.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pearlymarket.utilities.Driver;

public class Myaccount_pages_hamit {


    public Myaccount_pages_hamit(){
        PageFactory.initElements(Driver.getdriver(),this);
    }







    @FindBy(xpath = "(//h2)[1]")
    public WebElement buyuk_my_account;

    @FindBy(xpath = "(//div[@class='col-md-4 col-sm-6 col-12 m-b-md mb-4'])[1]")
    public WebElement orders;

    @FindBy(xpath = "(//div[@class='col-md-4 col-sm-6 col-12 m-b-md mb-4'])[2]")
    public WebElement downloads;

    @FindBy(xpath = "(//div[@class='col-md-4 col-sm-6 col-12 m-b-md mb-4'])[3]")
    public WebElement adresses;

    @FindBy(xpath = "(//div[@class='col-md-4 col-sm-6 col-12 m-b-md mb-4'])[4]")
    public WebElement account_details;

    @FindBy(xpath = "(//div[@class='icon-box text-center'])[5]")
    public WebElement wishlist;

    @FindBy(xpath = "(//div[@class='col-md-4 col-sm-6 col-12 m-b-md mb-4'])[6]")
    public WebElement logout;

    @FindBy(xpath = "//*[text()='Store Manager']")
    public WebElement store_manager_link;

    @FindBy(xpath = "//*[text()='Orders']")
    public WebElement orders_link;

    @FindBy(xpath = "//*[text()='Downloads']")
    public WebElement downloads_link;

    @FindBy(xpath = "//*[text()='Addresses']")
    public WebElement addressses_link;

    @FindBy(xpath = "//*[text()='Account details']")
    public WebElement account_details_link;

    @FindBy(xpath = "//*[text()='Wishlist']")
    public WebElement wishlist_link;

    @FindBy(xpath = "//*[text()='Support Tickets']")
    public WebElement support_tickets_link;

    @FindBy(xpath = "//*[text()='Followings']")
    public WebElement followings_link;

    @FindBy(xpath = "//*[text()='Logout']")
    public WebElement logout_link;



}//class


