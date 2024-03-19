package com.example.paragonPioneerBackend.Service;

import com.example.paragonPioneerBackend.Dto.RecipeDTO;
import com.example.paragonPioneerBackend.Entity.Recipe;
import com.example.paragonPioneerBackend.Repository.GoodRepository;
import com.example.paragonPioneerBackend.Repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service class for managing recipes in the application. It provides methods for creating,
 * updating, and retrieving recipes, with a focus on manipulating Recipe entities and
 * interacting with the database via the RecipeRepository. Additionally, it utilizes
 * GoodRepository for operations related to the Good entities that are part of the recipes.
 */
@Service(value = "recipeService")
public class RecipeService extends BaseService<Recipe, RecipeRepository, RecipeDTO> {

    private final GoodRepository goodRepository;

    /**
     * Constructor to autowire the RecipeRepository and GoodRepository, enabling
     * database operations for recipes and associated goods.
     *
     * @param repository The RecipeRepository for recipe database operations.
     * @param goodRepository The GoodRepository for good database operations.
     */
    @Autowired
    public RecipeService(RecipeRepository repository, GoodRepository goodRepository) {
        super(repository);
        this.goodRepository = goodRepository;
    }

    /**
     * Finds recipes where the output good's name contains a specified string.
     * Useful for searching recipes based on the name of the output good.
     *
     * @param outputName The name (or part of it) to search for in the output goods of recipes.
     * @return A list of recipes that match the search criteria.
     */
    public List<Recipe> findAllByNameContains(String outputName) {
        return repository.findAllByOutputNameContains(outputName);
    }

    /**
     * Finds a recipe by the name of its output good. Returns an optional recipe
     * which is useful for handling cases where the recipe may not exist.
     *
     * @param name The name of the output good.
     * @return An Optional containing the found recipe, if any.
     */
    public Optional<Recipe> findByName(String name) {
        return repository.findByOutputNameIs(name);
    }

    /**
     * Creates and saves a new recipe entity to the database based on the provided RecipeDTO.
     * This method overrides an abstract method from BaseService, tailored to handle Recipe entities.
     *
     * @param recipeDTO The RecipeDTO containing data for the new recipe.
     * @return The newly created and saved Recipe entity.
     */
    @Override
    public Recipe post(RecipeDTO recipeDTO) {
        return repository.save(Recipe.builder()
                .input1(recipeDTO.getInput1() != null ? goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 1)).orElse(null) : null)
                .input2(recipeDTO.getInput2() != null ? goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 2)).orElse(null) : null)
                .input3(recipeDTO.getInput3() != null ? goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 3)).orElse(null) : null)
                .input4(recipeDTO.getInput4() != null ? goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 4)).orElse(null) : null)
                .input5(recipeDTO.getInput5() != null ? goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 5)).orElse(null) : null)
                .input6(recipeDTO.getInput6() != null ? goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 6)).orElse(null) : null)
                .input7(recipeDTO.getInput7() != null ? goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 7)).orElse(null) : null)
                .input8(recipeDTO.getInput8() != null ? goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 8)).orElse(null) : null)
                .input9(recipeDTO.getInput9() != null ? goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 9)).orElse(null) : null)
                .input10(recipeDTO.getInput10() != null ? goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 10)).orElse(null) : null)
                .quantityOfInput1(recipeDTO.getQuantityOfInput1())
                .quantityOfInput2(recipeDTO.getQuantityOfInput2())
                .quantityOfInput3(recipeDTO.getQuantityOfInput3())
                .quantityOfInput4(recipeDTO.getQuantityOfInput4())
                .quantityOfInput5(recipeDTO.getQuantityOfInput5())
                .quantityOfInput6(recipeDTO.getQuantityOfInput6())
                .quantityOfInput7(recipeDTO.getQuantityOfInput7())
                .quantityOfInput8(recipeDTO.getQuantityOfInput8())
                .quantityOfInput9(recipeDTO.getQuantityOfInput9())
                .quantityOfInput10(recipeDTO.getQuantityOfInput10())
                .output(recipeDTO.getOutput() != null ? goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 11)).orElse(null) : null)
                .build());
    }

    /**
     * Updates an existing Recipe entity with data from the provided RecipeDTO.
     * This method overrides an abstract method from BaseService, tailored to Recipe entities.
     *
     * @param original  The original Recipe entity to be updated.
     * @param recipeDTO The RecipeDTO containing the updated data.
     * @return The updated Recipe entity.
     */
    @Override
    public Recipe putPatch(Recipe original, RecipeDTO recipeDTO) {
        original.setInput1(recipeDTO.getInput1() != null ? goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 1)).orElse(null) : original.getInput1());
        original.setInput2(recipeDTO.getInput2() != null ? goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 2)).orElse(null) : original.getInput2());
        original.setInput3(recipeDTO.getInput3() != null ? goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 3)).orElse(null) : original.getInput3());
        original.setInput4(recipeDTO.getInput4() != null ? goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 4)).orElse(null) : original.getInput4());
        original.setInput5(recipeDTO.getInput5() != null ? goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 5)).orElse(null) : original.getInput5());
        original.setInput6(recipeDTO.getInput6() != null ? goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 6)).orElse(null) : original.getInput6());
        original.setInput7(recipeDTO.getInput7() != null ? goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 7)).orElse(null) : original.getInput7());
        original.setInput8(recipeDTO.getInput8() != null ? goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 8)).orElse(null) : original.getInput8());
        original.setInput9(recipeDTO.getInput9() != null ? goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 9)).orElse(null) : original.getInput9());
        original.setInput10(recipeDTO.getInput10() != null ? goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 10)).orElse(null) : original.getInput10());

        original.setQuantityOfInput1(original.getQuantityOfInput1() != recipeDTO.getQuantityOfInput1() ? recipeDTO.getQuantityOfInput1() : original.getQuantityOfInput1());
        original.setQuantityOfInput2(original.getQuantityOfInput2() != recipeDTO.getQuantityOfInput2() ? recipeDTO.getQuantityOfInput2() : original.getQuantityOfInput2());
        original.setQuantityOfInput3(original.getQuantityOfInput3() != recipeDTO.getQuantityOfInput3() ? recipeDTO.getQuantityOfInput3() : original.getQuantityOfInput3());
        original.setQuantityOfInput4(original.getQuantityOfInput4() != recipeDTO.getQuantityOfInput4() ? recipeDTO.getQuantityOfInput4() : original.getQuantityOfInput4());
        original.setQuantityOfInput5(original.getQuantityOfInput5() != recipeDTO.getQuantityOfInput5() ? recipeDTO.getQuantityOfInput5() : original.getQuantityOfInput5());
        original.setQuantityOfInput6(original.getQuantityOfInput6() != recipeDTO.getQuantityOfInput6() ? recipeDTO.getQuantityOfInput6() : original.getQuantityOfInput6());
        original.setQuantityOfInput7(original.getQuantityOfInput7() != recipeDTO.getQuantityOfInput7() ? recipeDTO.getQuantityOfInput7() : original.getQuantityOfInput7());
        original.setQuantityOfInput8(original.getQuantityOfInput8() != recipeDTO.getQuantityOfInput8() ? recipeDTO.getQuantityOfInput8() : original.getQuantityOfInput8());
        original.setQuantityOfInput9(original.getQuantityOfInput9() != recipeDTO.getQuantityOfInput9() ? recipeDTO.getQuantityOfInput9() : original.getQuantityOfInput9());
        original.setQuantityOfInput10(original.getQuantityOfInput10() != recipeDTO.getQuantityOfInput10() ? recipeDTO.getQuantityOfInput10() : original.getQuantityOfInput10());


        original.setOutput(recipeDTO.getOutput() != null ? goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 11)).orElse(null) : original.getOutput());

        return original;
    }

    /**
     * Utility method to retrieve UUIDs from the Good numbers specified in the RecipeDTO.
     * Handles conversion from string identifiers and lookup via GoodRepository.
     *
     * @param recipeDTO The RecipeDTO containing good identifiers.
     * @param num       The specific input or output good number to lookup.
     * @return The UUID of the specified good, if found.
     */
    private UUID getUUIDFromGoodNumber(RecipeDTO recipeDTO, int num) {
        return switch (num) {
            case 1 -> {
                try {
                    yield UUID.fromString(recipeDTO.getInput1());
                } catch (IllegalArgumentException e) {
                    yield goodRepository.findByNameIs(recipeDTO.getInput1()).orElse(null).getId();
                }
            }
            case 2 -> {
                try {
                    yield UUID.fromString(recipeDTO.getInput2());
                } catch (IllegalArgumentException e) {
                    yield goodRepository.findByNameIs(recipeDTO.getInput2()).orElse(null).getId();
                }
            }
            case 3 -> {
                try {
                    yield UUID.fromString(recipeDTO.getInput3());
                } catch (IllegalArgumentException e) {
                    yield goodRepository.findByNameIs(recipeDTO.getInput3()).orElse(null).getId();
                }
            }
            case 4 -> {
                try {
                    yield UUID.fromString(recipeDTO.getInput4());
                } catch (IllegalArgumentException e) {
                    yield goodRepository.findByNameIs(recipeDTO.getInput4()).orElse(null).getId();
                }
            }
            case 5 -> {
                try {
                    yield UUID.fromString(recipeDTO.getInput5());
                } catch (IllegalArgumentException e) {
                    yield goodRepository.findByNameIs(recipeDTO.getInput5()).orElse(null).getId();
                }
            }
            case 6 -> {
                try {
                    yield UUID.fromString(recipeDTO.getInput6());
                } catch (IllegalArgumentException e) {
                    yield goodRepository.findByNameIs(recipeDTO.getInput6()).orElse(null).getId();
                }
            }
            case 7 -> {
                try {
                    yield UUID.fromString(recipeDTO.getInput7());
                } catch (IllegalArgumentException e) {
                    yield goodRepository.findByNameIs(recipeDTO.getInput7()).orElse(null).getId();
                }
            }
            case 8 -> {
                try {
                    yield UUID.fromString(recipeDTO.getInput8());
                } catch (IllegalArgumentException e) {
                    yield goodRepository.findByNameIs(recipeDTO.getInput8()).orElse(null).getId();
                }
            }
            case 9 -> {
                try {
                    yield UUID.fromString(recipeDTO.getInput9());
                } catch (IllegalArgumentException e) {
                    yield goodRepository.findByNameIs(recipeDTO.getInput9()).orElse(null).getId();
                }
            }
            case 10 -> {
                try {
                    yield UUID.fromString(recipeDTO.getInput10());
                } catch (IllegalArgumentException e) {
                    yield goodRepository.findByNameIs(recipeDTO.getInput10()).orElse(null).getId();
                }
            }
            case 11 -> {
                try {
                    yield UUID.fromString(recipeDTO.getOutput());
                } catch (IllegalArgumentException e) {
                    yield goodRepository.findByNameIs(recipeDTO.getOutput()).orElse(null).getId();
                }
            }

            default -> null;
        };
    }

    public Optional<Recipe> findAllByOutputId(UUID id) {
        var output = goodRepository.findById(id).orElse(null);

        if (output == null) {
            return Optional.empty();
        }
        return findByName(output.getName());
    }
}