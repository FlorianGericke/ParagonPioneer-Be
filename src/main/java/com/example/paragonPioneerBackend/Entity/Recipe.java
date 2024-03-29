package com.example.paragonPioneerBackend.Entity;

import com.example.paragonPioneerBackend.Entity.abstractEntity.BaseEntity;
import com.example.paragonPioneerBackend.Entity.abstractEntity.Slugable;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 * Represents a recipe within the application. A recipe is defined by a series of input goods along with their quantities
 * that are required to produce an output good. This entity extends the {@link BaseEntity} for common attributes like ID,
 * and implements the {@link Slugable} interface to use the slug of the output good for unique identification.
 */
@Entity
@Getter
@Setter
@ToString
@Table(name = "recipe")
@SQLDelete(sql = "UPDATE recipe SET deleted_at = current_date WHERE id=?")
@Where(clause = "deleted_at IS NULL")
@NoArgsConstructor
public class Recipe extends Slugable {

    /**
     * Defines a record to encapsulate a Good along with its required quantity within the recipe.
     */
    public record QuantityOfGood(Good good, int quantity) {
    }

    /**
     * The first input good required for the recipe.
     */
    @ManyToOne()
    @JoinColumn(name = "input_1")
    private Good input1;

    /**
     * The quantity of the first input good required.
     */
    @Column(name = "quantity_of_input_1")
    private int quantityOfInput1;

    /**
     * The second input good required for the recipe.
     */
    @ManyToOne()
    @JoinColumn(name = "input_2")
    private Good input2;

    /**
     * The quantity of the second input good required.
     */
    @Column(name = "quantity_of_input_2")
    private int quantityOfInput2;

    /**
     * The third input good required for the recipe.
     */
    @ManyToOne()
    @JoinColumn(name = "input_3")
    private Good input3;

    /**
     * The quantity of the third input good required.
     */
    @Column(name = "quantity_of_input_3")
    private int quantityOfInput3;

    /**
     * The fourth input good required for the recipe.
     */
    @ManyToOne()
    @JoinColumn(name = "input_4")
    private Good input4;

    /**
     * The quantity of the fourth input good required.
     */
    @Column(name = "quantity_of_input_4")
    private int quantityOfInput4;

    /**
     * The fifth input good required for the recipe.
     */
    @ManyToOne()
    @JoinColumn(name = "input_5")
    private Good input5;

    /**
     * The quantity of the fifth input good required.
     */
    @Column(name = "quantity_of_input_5")
    private int quantityOfInput5;

    /**
     * The sixth input good required for the recipe.
     */
    @ManyToOne()
    @JoinColumn(name = "input_6")
    private Good input6;

    /**
     * The quantity of the sixth input good required.
     */
    @Column(name = "quantity_of_input_6")
    private int quantityOfInput6;

    /**
     * The seventh input good required for the recipe.
     */
    @ManyToOne()
    @JoinColumn(name = "input_7")
    private Good input7;

    /**
     * The quantity of the seventh input good required.
     */
    @Column(name = "quantity_of_input_7")
    private int quantityOfInput7;


    /**
     * The eighth input good required for the recipe.
     */
    @ManyToOne()
    @JoinColumn(name = "input_8")
    private Good input8;

    /**
     * The quantity of the eighth input good required.
     */
    @Column(name = "quantity_of_input_8")
    private int quantityOfInput8;

    /**
     * The ninth input good required for the recipe.
     */
    @ManyToOne()
    @JoinColumn(name = "input_9")
    private Good input9;

    /**
     * The quantity of the ninth input good required.
     */
    @Column(name = "quantity_of_input_9")
    private int quantityOfInput9;


    /**
     * The tenth input good required for the recipe.
     */
    @ManyToOne()
    @JoinColumn(name = "input_10")
    private Good input10;

    /**
     * The quantity of the tenth input good required.
     */
    @Column(name = "quantity_of_input_10")
    private int quantityOfInput10;

    /**
     * The output good produced by the recipe.
     */
    @ManyToOne()
    @JoinColumn(name = "output", nullable = false)
    private Good output;

    @OneToOne()
    @JoinColumn(name = "production_building")
    private ProductionBuilding productionBuilding;

    /**
     * Constructs an array of {@link QuantityOfGood} objects representing each input good and its required quantity.
     * This method facilitates the aggregation of input goods and their quantities into a single array.
     *
     * @return An array of {@link QuantityOfGood} objects for the recipe.
     */
    public QuantityOfGood[] getQuantityOfGoods() {
        QuantityOfGood[] re = new QuantityOfGood[10];
        re[0] = new QuantityOfGood(getInput1(), getQuantityOfInput1());
        re[1] = new QuantityOfGood(getInput2(), getQuantityOfInput2());
        re[2] = new QuantityOfGood(getInput3(), getQuantityOfInput3());
        re[3] = new QuantityOfGood(getInput4(), getQuantityOfInput4());
        re[4] = new QuantityOfGood(getInput5(), getQuantityOfInput5());
        re[5] = new QuantityOfGood(getInput6(), getQuantityOfInput6());
        re[6] = new QuantityOfGood(getInput7(), getQuantityOfInput7());
        re[7] = new QuantityOfGood(getInput8(), getQuantityOfInput8());
        re[8] = new QuantityOfGood(getInput9(), getQuantityOfInput9());
        re[9] = new QuantityOfGood(getInput10(), getQuantityOfInput10());
        return re;
    }

    @Builder
    public Recipe(String name, String slug, Good input1, int quantityOfInput1, Good input2, int quantityOfInput2, Good input3, int quantityOfInput3, Good input4, int quantityOfInput4, Good input5, int quantityOfInput5, Good input6, int quantityOfInput6, Good input7, int quantityOfInput7, Good input8, int quantityOfInput8, Good input9, int quantityOfInput9, Good input10, int quantityOfInput10, Good output, ProductionBuilding productionBuilding) {
        super(name, slug);
        this.input1 = input1;
        this.quantityOfInput1 = quantityOfInput1;
        this.input2 = input2;
        this.quantityOfInput2 = quantityOfInput2;
        this.input3 = input3;
        this.quantityOfInput3 = quantityOfInput3;
        this.input4 = input4;
        this.quantityOfInput4 = quantityOfInput4;
        this.input5 = input5;
        this.quantityOfInput5 = quantityOfInput5;
        this.input6 = input6;
        this.quantityOfInput6 = quantityOfInput6;
        this.input7 = input7;
        this.quantityOfInput7 = quantityOfInput7;
        this.input8 = input8;
        this.quantityOfInput8 = quantityOfInput8;
        this.input9 = input9;
        this.quantityOfInput9 = quantityOfInput9;
        this.input10 = input10;
        this.quantityOfInput10 = quantityOfInput10;
        this.output = output;
        this.productionBuilding = productionBuilding;
    }
}
