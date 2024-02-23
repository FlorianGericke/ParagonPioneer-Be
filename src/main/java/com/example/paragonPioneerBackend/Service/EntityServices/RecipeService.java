package com.example.paragonPioneerBackend.Service.EntityServices;

import com.example.paragonPioneerBackend.Dto.RecipeDTO;
import com.example.paragonPioneerBackend.Entity.Recipe;
import com.example.paragonPioneerBackend.Repository.GoodRepository;
import com.example.paragonPioneerBackend.Repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * the Base handling the CRUD functions for the Recipe Entities. Extends BaseService
 */
@Service(value = "recipeService")
public class RecipeService extends BaseService<Recipe, RecipeRepository, RecipeDTO> {

    private final GoodRepository goodRepository;

    /**
     * Constructs a new RecipeService. is Autowired
     *
     * @param repository     the repository the Service should use
     * @param goodRepository the repository the Service should use
     */
    @Autowired
    public RecipeService(RecipeRepository repository, GoodRepository goodRepository) {
        super(repository);
        this.goodRepository = goodRepository;
    }

    /**
     * Find all Recipe whew the outputName contains
     *
     * @param outputName the string contained
     * @return list of Recipe matching
     */
    public List<Recipe> findAllByNameContains(String outputName) {
        return repository.findAllByOutputNameContains(outputName);
    }

    /**
     * Find Good by Name
     *
     * @param name the string contained
     * @return list of Goods matching
     */
    public Optional<Recipe> findByName(String name) {
        return repository.findByOutputNameIs(name);
    }

    /**
     * Adds new Entity to the database
     * Overridden from BaseService
     *
     * @param recipeDTO DTO responding to the Entity to add.
     * @return the added entity
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
     * Updates an Entity
     * Overridden from BaseService
     *
     * @param original  original entity
     * @param recipeDTO dto containing the updated data
     * @return the update entity
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
}