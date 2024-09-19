package utils;

public enum HeaderMenuItem {

    SEARCH("//a[@ng-reflect-router-link='search']"),
    LET_THE_CAR_WORK("//a[@ng-reflect-router-link='let-car-work']"),
    TERMS_OF_USE("//a[@ng-reflect-router-link='terms-of-use']"),
    SIGN_UP("//a[@ng-reflect-router-link='registration']"),
    LOG_IN("//a[@ng-reflect-router-link='login']");

    private final String locator;

    HeaderMenuItem(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return locator;
    }
}
