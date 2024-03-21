package com.example.paragonPioneerBackend.Calculator;

import com.example.paragonPioneerBackend.Entity.Good;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class ProductionKnot {

    private Good good;
    private ArrayList<ProductionKnot> ingredients = new ArrayList<>();

    public ProductionKnot(Good good) {
        this.good = good;
    }

    public void addIngredient(ProductionKnot ingredient) {
        ingredients.add(ingredient);
    }

    @Override
    public String toString() {
        return "ProductionKnot{" +
                "good=" + good +
                ", ingredients=" + ingredients +
                '}';
    }

    public String formatted(int tab) {
        StringBuilder sb = new StringBuilder();
        sb.append(tabCount(tab)).append(good.getName()).append("\n");
        for (ProductionKnot ingredient : ingredients) {
            sb.append(ingredient.formatted(tab + 1));
        }
        return sb.toString();
    }

    private String tabCount(int tab) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tab; i++) {
            sb.append("\t");
        }
        return sb.toString();
    }
}
