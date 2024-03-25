package com.example.paragonPioneerBackend.Calculator;

import com.example.paragonPioneerBackend.Entity.Building;
import com.example.paragonPioneerBackend.Entity.Good;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

/**
 * This is a class named ProductionKnot.
 * It represents a node in a production tree, where each node is a good that is produced by a building.
 * Each node can have multiple ingredients, which are also ProductionKnots.
 */
@Getter
@Setter
public class ProductionKnot {

    // The good that this node produces
    private Good good;
    // The building that produces this good
    private Building manufacturer;
    // The ingredients required to produce this good
    private ArrayList<ProductionKnot> ingredients = new ArrayList<>();

    /**
     * Constructor for the ProductionKnot class.
     * Initializes the good and the manufacturer.
     */
    public ProductionKnot(Good good, Building manufacturer) {
        this.good = good;
        this.manufacturer = manufacturer;
    }

    /**
     * Adds an ingredient to the list of ingredients.
     */
    public void addIngredient(ProductionKnot ingredient) {
        ingredients.add(ingredient);
    }

    /**
     * Returns a string representation of the ProductionKnot.
     */
    @Override
    public String toString() {
        return "ProductionKnot{" +
                "good=" + good +
                ", ingredients=" + ingredients +
                '}';
    }

    /**
     * Returns a formatted string representation of the ProductionKnot.
     * The string is indented by the number of tabs specified by the parameter.
     */
    public String formatted(int tab) {
        StringBuilder sb = new StringBuilder();
        sb.append(tabCount(tab)).append(good.getName()).append("\n");
        for (ProductionKnot ingredient : ingredients) {
            sb.append(ingredient.formatted(tab + 1));
        }
        return sb.toString();
    }

    /**
     * Returns a string of tabs.
     * The number of tabs is specified by the parameter.
     */
    private String tabCount(int tab) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tab; i++) {
            sb.append("\t");
        }
        return sb.toString();
    }
}