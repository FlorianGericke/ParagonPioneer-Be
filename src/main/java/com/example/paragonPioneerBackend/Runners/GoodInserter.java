package com.example.paragonPioneerBackend.Runners;

import com.example.paragonPioneerBackend.Entity.Good;
import com.example.paragonPioneerBackend.Repository.GoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GoodInserter{
    private final GoodRepository repository;

    private record Inserter(String name, String remarks) {
    }

    Inserter[] inserts = {
            new Inserter("Coin", "Global"),
            new Inserter("Cartography", "Global, used for Discovery"),
            new Inserter("Favor", "Global, needed for more island slots"),
            new Inserter("Wood", "Build material"),
            new Inserter("Fish", ""),
            new Inserter("Plank", "Build material"),
            new Inserter("Schnapps", ""),
            new Inserter("Stone", "Build material"),
            new Inserter("Linseed", ""),
            new Inserter("Linen", ""),
            new Inserter("Bow", ""),
            new Inserter("Archer", ""),
            new Inserter("Ropes", ""),
            new Inserter("Copper Ore", ""),
            new Inserter("Copper Ingot", ""),
            new Inserter("Copper Sword", ""),
            new Inserter("Yarn", ""),
            new Inserter("Fabric", ""),
            new Inserter("Wheat", ""),
            new Inserter("Flour", ""),
            new Inserter("Bread", ""),
            new Inserter("Tobacco", ""),
            new Inserter("Cigar", ""),
            new Inserter("Sail", ""),
            new Inserter("Horse", ""),
            new Inserter("Longbow", ""),
            new Inserter("Clay", ""),
            new Inserter("Brick", "Build material"),
            new Inserter("Clothes", ""),
            new Inserter("Malt", ""),
            new Inserter("Hops", ""),
            new Inserter("Beer", ""),
            new Inserter("Cattle", ""),
            new Inserter("Rock Salt", ""),
            new Inserter("Salt", ""),
            new Inserter("Meat", ""),
            new Inserter("Coal", ""),
            new Inserter("Gold Ore", ""),
            new Inserter("Gold", ""),
            new Inserter("Gold Ingot", ""),
            new Inserter("Gold Jewelry", ""),
            new Inserter("Linseed Oil", ""),
            new Inserter("Iron Ore", ""),
            new Inserter("Iron Ingot", ""),
            new Inserter("Iron Sword", ""),
            new Inserter("Militia", ""),
            new Inserter("Tools", "Build material"),
            new Inserter("Crossbow", ""),
            new Inserter("Marble", "Build material"),
            new Inserter("Silk", ""),
            new Inserter("Silk Cloth", ""),
            new Inserter("Dye", ""),
            new Inserter("Garment", ""),
            new Inserter("Gemstone", ""),
            new Inserter("Goblet", ""),
            new Inserter("Honey", ""),
            new Inserter("Candle", ""),
            new Inserter("Candle Holder", ""),
            new Inserter("Liqueur", ""),
            new Inserter("Lobster", ""),
            new Inserter("Feast", ""),
            new Inserter("Grapes", ""),
            new Inserter("Barrel", ""),
            new Inserter("Wine", ""),
            new Inserter("Windjammer", ""),
            new Inserter("Book", ""),
            new Inserter("Coke", ""),
            new Inserter("Steel Ingot", ""),
            new Inserter("Armored Horse", ""),
            new Inserter("Saltpeter", ""),
            new Inserter("Gunpowder", ""),
            new Inserter("Cannon", ""),
            new Inserter("Metal Cuttings", ""),
            new Inserter("Fireworks", ""),
            new Inserter("Land tile", ""),
            new Inserter("Mountain tile", ""),
            new Inserter("Hop Field", ""),
            new Inserter("Horse Field", ""),
            new Inserter("Indigo Field", ""),
            new Inserter("Linseed Field", ""),
            new Inserter("Potato Field", ""),
            new Inserter("Water tile", ""),
            new Inserter("Sheep Field", ""),
            new Inserter("Mulberry Trees", ""),
            new Inserter("Tobacco Field", ""),
            new Inserter("Wheat Field", ""),
            new Inserter("Vineyard", ""),
    };

    public void run() {
        for (Inserter insert : inserts) {
            repository.save(Good.builder().name(insert.name).remarks(insert.remarks).build());
        }
    }
}
