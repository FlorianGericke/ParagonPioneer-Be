//package com.example.paragonPioneerBackend.Calculator;
//
//import com.example.paragonPioneerBackend.Dto.ProductionBuildingDTO;
//import com.example.paragonPioneerBackend.Entity.Good;
//import com.example.paragonPioneerBackend.Entity.Recipe;
//import com.example.paragonPioneerBackend.Exception.EntityNotFoundException;
//import com.example.paragonPioneerBackend.Service.BuildingService;
//import com.example.paragonPioneerBackend.Service.GoodService;
//import com.example.paragonPioneerBackend.Service.RecipeService;
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
//public class Calculator {
//
//
//    private final ProductionKnot target;
//    private final RecipeService recipeService;
//    private final GoodService goodService;
//    private final BuildingService<ProductionBuildingDTO> productionBuildingDTOBuildingService;
//
//
//    public Calculator(RecipeService recipeService, GoodService goodService, ProductionKnot target, BuildingService<ProductionBuildingDTO> productionBuildingDTOBuildingService) {
//        this.target = target;
//        this.recipeService = recipeService;
//        this.goodService = goodService;
//        this.productionBuildingDTOBuildingService = productionBuildingDTOBuildingService;
//        setUp(this.target);
//    }
//
//    public Calculator(RecipeService recipeService, GoodService goodService, String goodName, float amount, BuildingService<ProductionBuildingDTO> productionBuildingDTOBuildingService) {
//        this(recipeService, goodService, new ProductionKnot(goodName, amount, productionBuildingDTOBuildingService.getProductionBuildingByRecipe(goodName).getName()),productionBuildingDTOBuildingService);
//    }
//
//    private void setUp(ProductionKnot target) {
//
//
//        //todo I need a base case know when to stop the recursive process, throw an exception is not ok !!!
//        Good good = goodService.findByName(target.getGoodName()).orElseThrow(() -> new EntityNotFoundException(target.getGoodName()));
//
//        if (good.getName().contains("tile")) {
//            return;
//        }
//
//        Recipe recipe = recipeService.findByName(good.getName()).orElseThrow(() -> new EntityNotFoundException(target.getGoodName() + "\n" + this.target.toString()));
//
//        for (Recipe.QuantityOfGood ingredient : recipe.getQuantityOfGoods()) {
//            if (ingredient.good() == null) {
//                continue;
//            }
//
//            ProductionKnot knot = null;
//            if (recipeService.findByName(ingredient.good().getName()).isEmpty()) {
//                knot = new ProductionKnot(ingredient.good().getName(), ingredient.quantity() * target.getAmount(), "Unknown");
//
//            } else {
//                knot = new ProductionKnot(ingredient.good().getName(), ingredient.quantity() * target.getAmount(), productionBuildingDTOBuildingService.getProductionBuildingByRecipe(ingredient.good().getName()).getName());
//            }
//            setUp(knot);
//            target.addNeed(knot);
//        }
//    }
//
//    public String getFormatted() {
//        StringBuilder st = new StringBuilder("For the production of ").append(target.getGoodName()).append(" (").append(target.getProductionBuilding()).append(")\n");
//        st.append("\t");
//        for (ProductionStack stack : target.getNeeds()) {
//            ProductionStack cp = (ProductionStack) stack.clone();
//            cp.forEach(knot -> st.append(knot.toString(1)));
//        }
//        return st.toString();
//    }
//}
