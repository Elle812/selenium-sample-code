package com.vlasova.selenium.target;

/**
 * Created by vlasova on 9/24/17.
 */
public class TargetWebsiteElements {
    public static final String URL = "http://www.target.com";
    public static final String TITLE_MAIN_PAGE = "Target : Expect More. Pay Less.";

    public static final String SEARCH_LABEL = "searchLabel";
    public static final String SEARCH_TEXTFIELD = "search";
    public static final String URL_AFTER_SEARCH = "https://www.target.com/s?searchTerm=";
    public static final String SIGN_IN_OR_CREATE_AN_ACCOUNT_URL = "https://www.target.com/co-login?interstitial=true&redirectToURL=co-deliverymethod";

    public static final String PRODUCT_LINK = "product--link";
    public static final String ADD_TO_CART = "//*[@id=\"AddToCartAreaId\"]/div[1]/div/button";
    public static final String VIEW_CART_AND_CHECKOUT = "//*[@id=\"block-ATC\"]/div[2]/div/div[2]/div/div[1]/div[2]/button[2]";
    public static final String READY_TO_CHECKOUT = "signed";

    public static final String MY_ACCOUNT = "js-toggleRightNavLg";
    public static final String SIGN_IN = "rightNav-signIn";
    public static final String CREATE_ACCOUNT = "createAccount";
    public static final String EMAIL_TEXTFIELD = "username";
    public static final String FIRST_NAME = "firstname";
    public static final String LAST_NAME = "lastname";
    public static final String PASSWORD = "password";
    public static final String EMAIL_LOGIN = "logonIdMain";
    public static final String PASSWORD_LOGIN = "logonPasswordMain";
}
