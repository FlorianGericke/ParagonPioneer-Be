package com.example.paragonPioneerBackend.Bin.Config.Data.EntityInserters;

import com.example.paragonPioneerBackend.Dto.BuildingDTO;
import com.example.paragonPioneerBackend.Dto.PopulationBuildingDTO;
import com.example.paragonPioneerBackend.Dto.ProductionBuildingDTO;
import com.example.paragonPioneerBackend.Service.EntityServices.BuildingService;
import com.example.paragonPioneerBackend.Service.EntityServices.RecipeService;
import com.example.paragonPioneerBackend.Util.OptionalUtil;
import com.example.paragonPioneerBackend.Util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * Setup all data for Buildings
 */
@Component
@RequiredArgsConstructor
public class BuildingInserter {
    private final BuildingService<BuildingDTO> buildingService;
    private final RecipeService recipeService;

    private record Inserter(String name, String recipe, float productionPerMinute, String remarks) {
    }

    private final Inserter[] inserts = {
            new Inserter("Lumberjack", "Wood", 5f, ""),
            new Inserter("Well", "Water", 0.01667f, ""),
            new Inserter("Fishermans Hut","Fish",0.75f,""),
            new Inserter("Sawmill","Plank",5f,""),
            new Inserter("Potato Field","Potato Field",0.01667f,""),
            new Inserter("Potato Farm","Schnapps",1f,""),
            new Inserter("Tavern","Community",0.01667f,""),
            new Inserter("Linseed Field","Linseed Field",0.01667f,""),
            new Inserter("Linseed Farm","Linseed",0.5f,""),
            new Inserter("Linen Weaver","Linen",0.5f,""),
            new Inserter("Bowyer","Bow",0.5f,""),
            new Inserter("Archery Range","Archer",0.1f,""),
            new Inserter("Ropery","Ropes",0.5f,""),
            new Inserter("Stonecutter","Stone",0.14286f,""),
            new Inserter("Copper Mine","Copper Ore",0.25f,""),
            new Inserter("Copper Smelter","Copper Ingot",0.125f,""),
            new Inserter("Copper Armory","Copper Sword",0.125f,""),
            new Inserter("Barracks","Footsoldier",0.1f,""),
            new Inserter("Sheep Field","Sheep Field",0.01667f,""),
            new Inserter("Sheep Farm","Yarn",0.5f,""),
            new Inserter("Wheat Field","Wheat Field",0.01667f,""),
            new Inserter("Wheat Farm","Wheat",0.5f,""),
            new Inserter("Windmill","Flour",0.5f,""),
            new Inserter("Bakery","Bread",0.25f,""),
            new Inserter("Horse Field","Horse Field",0.01667f,""),
            new Inserter("Horse Breeder","Horse",0.01667f,""),
            new Inserter("Riding Arena","Cavalry",0.1f,""),
            new Inserter("Tobacco Field","Tobacco Field",0.01667f,""),
            new Inserter("Tobacco Farm","Tobacco",0.5f,""),
            new Inserter("Cigar Manufacturer","Cigar",0.5f,""),
            new Inserter("Sailmaker","Sail",0.25f,""),
            new Inserter("Clay Pit","Clay",0.5f,""),
            new Inserter("Brickyard","Brick",0.25f,""),
            new Inserter("Longbowyer","Longbow",0.5f,""),
            new Inserter("Longbow Archer Range","Longbow Archer",0.1f,""),
            new Inserter("Cotton Field","Cotton Field",0.01667f,""),
//            new Inserter("Cotton Plantation","Yarn",1f,""), todo at the moment the backen does not support multiple variants to produce a good
            new Inserter("Tailor","Clothes",0.25f,""),
            new Inserter("Hop Field","Hop Field",0.01667f,""),
            new Inserter("Hop Farm","Hops",0.5f,""),
            new Inserter("Malthouse","Malt",0.5f,""),
            new Inserter("Brewery","Beer",0.5f,""),
            new Inserter("Linseed Pil Press","Linseed Oil",0.33333f,""),
            new Inserter("Medicus","Medical Care",0.01667f,""),
            new Inserter("Iron Mine","Iron Ore",0.25f,""),
            new Inserter("Iron Smelter","Iron Ingot",0.125f,""),
            new Inserter("Toolmaker","Tools",0.25f,""),
            new Inserter("Iron Armory","Iron Sword",0.125f,""),
            new Inserter("Knight Barracks","Knight",0.1f,""),
            new Inserter("Cattle Field","Cattle Field",0.01667f,""),
            new Inserter("Cattle Ranch","Cattle",0.25f,""),
            new Inserter("Rock Salt Mine","Rock Salt",0.25f,""),
            new Inserter("Butchers Shop","Meat",1f,""),
            new Inserter("Gold Mine","Gold Ore",0.25f,""),
            new Inserter("Gold Smelter","Gold Ingot",0.125f,""),
            new Inserter("Goldsmith","Gold Jewelery",0.125f,""),
            new Inserter("Crossbow Maker","Crossbow",0.25f,""),
            new Inserter("Crossbow Shooting Range","Crossbowman",0.1f,""),
            new Inserter("Marble Quarry","Marble",0.25f,""),
            new Inserter("School","Education",0.01667f,""),
            new Inserter("Bathhouse","Hygiene",0.01667f,""),
            new Inserter("Bathhouse providing water","Water",0.01667f,""),
            new Inserter("Mulberry Trees","Mulberry Trees",0.01667f,""),
            new Inserter("Silk Plantation","Silk",0.5f,""),
            new Inserter("Silk Twine Mill","Silk Cloth",0.5f,""),
            new Inserter("Indigo Field","Indigo Field",0.01667f,""),
            new Inserter("Indigo Plantation","Dye",0.5f,""),
            new Inserter("Noble Tailor","Garment",0.25f,""),
            new Inserter("Gemstone Mine","Gem",0.33333f,""),
            new Inserter("Goblet Manufacturer","Goblet",0.25f,""),
            new Inserter("Beehive","Beehive",0.01667f,""),
            new Inserter("Apiary","Honey",0.25f,""),
            new Inserter("Chandler","Candle",0.5f,""),
            new Inserter("Fine Forge","Candle Holder",0.75f,""),
            new Inserter("Cokery","Coke",0.25f,""),
            new Inserter("Steel Furnace","Steel Ingot",0.25f,""),
            new Inserter("Armorsmith","Armored Horse",0.25f,""),
            new Inserter("Cuirassier Academy","Cuirassier",0.1f,""),
            new Inserter("Distillery","Liqueur",0.5f,""),
            new Inserter("Lobsterer","Lobster",1.5f,""),
            new Inserter("Noble Kitchen","Feast",1.5f,""),
            new Inserter("Vineyard","Vineyard",0.01667f,""),
            new Inserter("Winery","Grape",0.75f,""),
            new Inserter("Cooper","Barrel",0.75f,""),
            new Inserter("Winepress","Wine",0.75f,""),
            new Inserter("Paper Mill","Paper",0.5f,""),
            new Inserter("BookBinder","Book",0.125f,""),
            new Inserter("Nitrate Maker","Salpetre",0.25f,""),
            new Inserter("Powder Mill","Gunpowder",0.25f,""),
            new Inserter("Cannon Foundry","Cannon",0.125f,""),
            new Inserter("Cannoneers School","Cannoneer",0.1f,""),
            new Inserter("Planing Mill","Metal Cuttings",0.5f,""),
            new Inserter("Gunsmith","Fireworks",0.25f,""),
            new Inserter("Tiltyard","Gambling",0.01667f,""),
            new Inserter("University","University",0.01667f,""),
    };
    /*
        new Inserter("","",f,""),
     */

    /**
     * Run the insertions
     */
    public void run() {
        buildingService.post(PopulationBuildingDTO.builder().name(StringUtil.toLower("Pioneer's Hut")).capacity(10).remarks("").build());
        buildingService.post(PopulationBuildingDTO.builder().name(StringUtil.toLower("Colonist's House")).capacity(15).remarks("").build());
        buildingService.post(PopulationBuildingDTO.builder().name(StringUtil.toLower("Townsmen's House")).capacity(20).remarks("").build());
        buildingService.post(PopulationBuildingDTO.builder().name(StringUtil.toLower("Merchant's Mansion")).capacity(25).remarks("").build());
        buildingService.post(PopulationBuildingDTO.builder().name(StringUtil.toLower("Paragon's Residence")).capacity(30).remarks("").build());

        for (Inserter insert : inserts) {

            buildingService.post(ProductionBuildingDTO.builder()
                    .name(StringUtil.toLower(insert.name))
                    .remarks(StringUtil.toLower(insert.remarks))
                    .idOfRecipe(OptionalUtil.getIdOrEmpty(recipeService.findByName(StringUtil.toLower(insert.recipe))))
                    .productionPerMinute(insert.productionPerMinute)
                    .build());
        }
    }
}
