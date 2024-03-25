package com.example.paragonPioneerBackend.Calculator;

import java.util.ArrayList;

/**
 * This is a record class named CalculationResponse.
 * A record is a special kind of class in Java that is used to model plain data aggregates with final state and behavior that depends only on that state.
 *
 * The CalculationResponse record has two components:
 * - target: An instance of the ProductionKnot class. This represents the target of the calculation.
 * - errors: An ArrayList of Strings. This list contains any errors that occurred during the calculation.
 */
public record CalculationResponse(ProductionKnot target, ArrayList<String> errors) {
}