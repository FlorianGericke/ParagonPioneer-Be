package com.example.paragonPioneerBackend.Calculator;

import com.example.paragonPioneerBackend.Entity.ProductionBuilding;
import com.example.paragonPioneerBackend.Entity.abstractEntity.Building;
import com.example.paragonPioneerBackend.Entity.Good;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

/**
 * The ProductionKnot class represents a node in a production tree.
 * Each node is a good that is produced by a building.
 * Each node can have multiple ingredients, which are also ProductionKnots.
 */
@Getter
@Setter
public class ProductionKnot {

    /**
     * The good that this node produces.
     */
    private Good good;

    /**
     * The building that produces this good.
     */
    private Building manufacturer;

    /**
     * The ingredients required to produce this good.
     * Each ingredient is represented as a ProductionKnot.
     */
    private ArrayList<ProductionKnot> ingredients = new ArrayList<>();

    /**
     * Constructor for the ProductionKnot class.
     * Initializes the good and the manufacturer.
     *
     * @param good The good that this node produces.
     * @param manufacturer The productionBuilding that produces this good.
     */
    public ProductionKnot(Good good, ProductionBuilding manufacturer) {
        this.good = good;
        this.manufacturer = manufacturer;
    }

    /**
     * Adds an ingredient to the list of ingredients.
     *
     * @param ingredient The ingredient to add.
     */
    public void addIngredient(ProductionKnot ingredient) {
        ingredients.add(ingredient);
    }

    /**
     * Returns a string representation of the ProductionKnot.
     *
     * @return A string representation of the ProductionKnot.
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
     *
     * @param tab The number of tabs to indent the string.
     * @return A formatted string representation of the ProductionKnot.
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
     *
     * @param tab The number of tabs to include in the string.
     * @return A string of tabs.
     */
    private String tabCount(int tab) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tab; i++) {
            sb.append("\t");
        }
        return sb.toString();
    }
}