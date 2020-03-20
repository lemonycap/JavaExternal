package com.example.parsers.utils;

import candies.Candy;

import java.util.Set;

public class Helper {
    public static void printCandies(Set<Candy> candies) {
        for (Candy c : candies) {
            System.out.println("Product name: " + c.getProductName());
            System.out.println("Filling: " + c.getFilling());
            System.out.println("Candy name: " + c.getName());
            System.out.println("Energy" + c.getEnergy());
            System.out.println("Candy type: " + c.getType());
            System.out.println("Ingredients:");
            System.out.println("Water: " + c.getIngredients().getWater());
            System.out.println("Sugar: " + c.getIngredients().getSugar());
            System.out.println("Fructose: " + c.getIngredients().getFructose());
            System.out.println("Vaniline: " + c.getIngredients().getVaniline());
            System.out.println("Chocolate type: " + c.getIngredients().getChocolateType());
            System.out.println("Value:");
            System.out.println("Proteins: " + c.getValue().getProtein());
            System.out.println("Fats: " + c.getValue().getFat());
            System.out.println("Carbs: " + c.getValue().getCarb());
            System.out.println("Product owner: " + c.getProductOwner());
        }
    }
}
