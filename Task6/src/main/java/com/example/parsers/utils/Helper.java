package com.example.parsers.utils;

import candies.Candy;
import com.example.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Helper {

    public static void sortCandies (Set<Candy> candies) {
        List<Candy> listCandies = candies.stream().collect(Collectors.toList());
        Collections.sort(listCandies, (o1, o2) -> o1.getProductOwner().compareTo(o2.getProductOwner()));
        for (int i = 0; i < listCandies.size(); i++) {
           printCandies(listCandies);
        }
    }
    public static void printCandies(List<Candy> candies) {
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

    public static int chooseParser(BufferedReader br) {
        while (true) {
            try {
                String input = br.readLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException | IOException e) {
                View.printMessage(View.WRONG_INPUT);
            }
        }
    }

    public static int measuresCheck(int min, int max) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = chooseParser(br);
        while (number > max || number < min) {
            View.printMessage(View.WRONG_INPUT);
            number = chooseParser(br);
        }
        return number;
    }
}
