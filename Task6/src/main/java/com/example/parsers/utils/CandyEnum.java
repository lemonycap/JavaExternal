package com.example.parsers.utils;

public enum CandyEnum {
    CANDIES ("com/example/model/candies"),
    PRODUCT_NAME ("productName"),
    FILLING ("filling"),
    CANDY ("candy"),
    NAME ("name"),
    ENERGY ("energy"),
    TYPE ("type"),
    INGREDIENTS (Constants.INGR),
    WATER ("water"),
    SUGAR ("sugar"),
    FRUCTOSE ("fructose"),
    VANILINE ("vaniline"),
    CHOCOLATE_TYPE ("chocolate-type"),
    VALUE (Constants.VAL),
    PROTEINS ("proteins"),
    FATS ("fats"),
    CARBS ("carbs"),
    PRODUCT_OWNER ("product-owner");
    private String value;
    private CandyEnum (String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

    private static class Constants {
        private static final String INGR = "Ingredients";
        private static final String VAL = "Value";
    }
}
