package Utils;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

@Name("https://magento.softwaretestingboard.com/")
public class ShopPage extends WebPage{

    @Name("Men button")
    public static SelenideElement manButton = $("#ui-id-5");
    @Name("Gear button")
    public static SelenideElement gearButton = $("#ui-id-6");
    @Name("Bottoms button")
    public static SelenideElement bottomsButton = $("#ui-id-18");
    @Name("Shorts button")
    public static SelenideElement shortsButton = $("#ui-id-24");
    @Name("Shorts item")
    public static ElementsCollection shortsItem = $$(byXpath("//li[@class='item product product-item']"));
    @Name("Cart button")
    public static SelenideElement cartButton = $("body > div.page-wrapper > header > div.header.content > div.minicart-wrapper > a");
    @Name("Checkout button")
    public static SelenideElement checkoutButton = $("#top-cart-btn-checkout");
    @Name("Email input")
    public static SelenideElement emailInput = $("#customer-email");
    @Name("First name input")
    public static SelenideElement firstNameInput = $x("//*[@name='shippingAddress.firstname']//input");
    @Name("Last name input")
    public static SelenideElement lastNameInput = $x("//*[@name='shippingAddress.lastname']//input");
    @Name("Street address input")
    public static SelenideElement streetAddressInput = $x("//*[@name='shippingAddress.street.0']//input");
    @Name("City input")
    public static SelenideElement cityInput = $x("//*[@name='shippingAddress.city']//input");
    @Name("State-province button")
    public static SelenideElement button = $x("//*[@name='shippingAddress.region_id']//select");
    @Name("California item")
    public static SelenideElement california = $(byXpath("//*[contains(text(),'California')]"));
    @Name("Postal code input")
    public static SelenideElement postalCodeInput = $x("//*[@name='shippingAddress.postcode']//input");
    @Name("Phone number input")
    public static SelenideElement phoneNumberInput = $x("//*[@name='shippingAddress.telephone']//input");
    @Name("Next button")
    public static SelenideElement nextButton = $("#shipping-method-buttons-container > div > button");
    @Name("Place order button")
    public static SelenideElement placeOrderButton = $("#checkout-payment-method-load > div > div > div.payment-method._active > div.payment-method-content > div.actions-toolbar > div > button");
    @Name("Confirmation label")
    public static SelenideElement confirmationLabel = $("#maincontent > div.page-title-wrapper > h1 > span");
    @Name("Items counter label")
    public static SelenideElement itemsCounterLabel = $("body > div.page-wrapper > header > div.header.content > div.minicart-wrapper > a > span.counter.qty > span.counter-number");
    @Name("Shipping method radiobutton")
    public static SelenideElement shippingMethod = $x("//*[@data-bind='click: element.selectShippingMethod']//input");
    @Name("Watches button")
    public static SelenideElement watchesButton = $("#ui-id-27");
    @Name("Watch item")
    public static ElementsCollection watchItem = $$(byXpath("//li[@class='item product product-item']"));
    @Name("Minicart")
    public static SelenideElement minicart = $x("//*[@id=\"mini-cart\"]");
    @Name("Product item")
    public static WebElementWrapper productItems = new WebElementWrapper("//li[@class='item product product-item']");
    @Name("Confirm button")
    public static SelenideElement confirmButton = $x("/html/body/div[2]/aside[2]/div[2]/footer/button[2]");

}
