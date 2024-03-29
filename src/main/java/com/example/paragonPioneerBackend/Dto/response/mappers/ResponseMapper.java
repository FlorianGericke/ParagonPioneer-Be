package com.example.paragonPioneerBackend.Dto.response.mappers;

/**
 * The ResponseMapper interface is a functional interface that defines a single method, map.
 * This interface is used to map an object of type I (input) to an object of type R (response).
 * The actual mapping logic is provided by the implementation of this interface.
 * This interface is annotated with @FunctionalInterface, which indicates that it is intended to be used as a lambda or method reference.
 *
 * @param <R> The type of the response object.
 * @param <I> The type of the input object.
 */
@FunctionalInterface
public interface ResponseMapper<R,I> {
    /**
     * This method is used to map an object of type I (input) to an object of type R (response).
     * The actual mapping logic is provided by the implementation of this method.
     *
     * @param input The input object to be mapped.
     * @return The response object resulting from the mapping.
     */
    R map(I input);
}