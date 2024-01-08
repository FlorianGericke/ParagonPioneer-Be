package com.example.paragonPioneerBackend.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 * Entity representing a Recipe
 */
@Entity
@Getter
@Setter
@ToString
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE recipe SET deleted_at = current_date WHERE id=?")
@Where(clause = "deleted_at IS NULL")
public class Recipe extends BaseEntity {

    public record QuantityOfGood(Good good, int quantity) {
    }

    @ManyToOne()
    @JoinColumn(name = "input_1", nullable = true)
    private Good input1;

    @Column(name = "quantity_of_input_1")
    private int quantityOfInput1;

    @ManyToOne()
    @JoinColumn(name = "input_2", nullable = true)
    private Good input2;

    @Column(name = "quantity_of_input_2")
    private int quantityOfInput2;

    @ManyToOne()
    @JoinColumn(name = "input_3", nullable = true)
    private Good input3;

    @Column(name = "quantity_of_input_3")
    private int quantityOfInput3;

    @ManyToOne()
    @JoinColumn(name = "input_4", nullable = true)
    private Good input4;

    @Column(name = "quantity_of_input_4")
    private int quantityOfInput4;

    @ManyToOne()
    @JoinColumn(name = "input_5", nullable = true)
    private Good input5;

    @Column(name = "quantity_of_input_5")
    private int quantityOfInput5;

    @ManyToOne()
    @JoinColumn(name = "input_6", nullable = true)
    private Good input6;

    @Column(name = "quantity_of_input_6")
    private int quantityOfInput6;

    @ManyToOne()
    @JoinColumn(name = "input_7", nullable = true)
    private Good input7;

    @Column(name = "quantity_of_input_7")
    private int quantityOfInput7;

    @ManyToOne()
    @JoinColumn(name = "input_8", nullable = true)
    private Good input8;

    @Column(name = "quantity_of_input_8")
    private int quantityOfInput8;

    @ManyToOne()
    @JoinColumn(name = "input_9", nullable = true)
    private Good input9;

    @Column(name = "quantity_of_input_9")
    private int quantityOfInput9;

    @ManyToOne()
    @JoinColumn(name = "input_10", nullable = true)
    private Good input10;

    @Column(name = "quantity_of_input_10")
    private int quantityOfInput10;

    @ManyToOne()
    @JoinColumn(name = "output", nullable = true)
    private Good output;

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
}
