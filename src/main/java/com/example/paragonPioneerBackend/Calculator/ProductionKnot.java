//package com.example.paragonPioneerBackend.Calculator;
//
//import lombok.AccessLevel;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//@Getter
//@Setter
//public class ProductionKnot {
//
//
//    public record Need(String good, float perMinute) {
//    }
//
//    private String goodName;
//    private float amount;
//    private String productionBuilding;
//
//
//    public ProductionKnot(String goodName, float amount, String productionBuilding) {
//        this.goodName = goodName;
//        this.amount = amount;
//        this.productionBuilding =productionBuilding;
//        this.needs = new ArrayList<>();
//    }
//
//    @Setter(AccessLevel.NONE)
//    private List<ProductionStack> needs;
//
//
//    public void addNeed(ProductionKnot need) {
//        ProductionStack inserter = new ProductionStack();
//        inserter.add(need);
//        needs.add(inserter);
//    }
//
//    public void addNeed(Need need) {
//        ProductionStack inserter = new ProductionStack();
//        ProductionKnot knot = new ProductionKnot(need.good, need.perMinute, productionBuilding);
//        inserter.add(knot);
//        needs.add(inserter);
//    }
//
//    public ProductionKnot clone() {
//        ProductionKnot copy = new ProductionKnot(this.goodName, amount, this.productionBuilding);
//
//        copy.needs = new ArrayList<>();
//
//        for (ProductionStack stack : needs) {
//            copy.needs.add((ProductionStack) stack.clone());
//        }
//
//        return copy;
//    }
//
//    public void addNeed(String goodName, float amount) {
//        this.addNeed(new Need(goodName, amount));
//    }
//
//    public void addNeeds(Collection<Need> needs) {
//        needs.forEach(this::addNeed);
//    }
//
//    @Override
//    public String toString() {
//        return this.toString(0);
//    }
//
//    public String toString(int indent) {
//        StringBuilder st = new StringBuilder();
//        for (int i = 0; i < indent; i++) {
//            st.append("\t");
//        }
//        st.append(this.goodName).append(" : ").append(this.amount).append(" (").append(productionBuilding).append(")\n");
//        for (int i = 0; i < indent; i++) {
//            st.append("\t");
//        }
//        for (ProductionStack stack : getNeeds()) {
//            ProductionStack cp = (ProductionStack) stack.clone();
//            cp.forEach(knot -> st.append(knot.toString(indent + 1)));
//            for (int i = 0; i < indent; i++) {
//                st.append("\t");
//
//            }
//        }
//        return st.toString();
//    }
//}
