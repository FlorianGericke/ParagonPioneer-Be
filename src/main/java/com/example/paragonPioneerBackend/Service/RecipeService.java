package com.example.paragonPioneerBackend.Service;

import com.example.paragonPioneerBackend.Dto.requests.RecipeInput;
import com.example.paragonPioneerBackend.Entity.Recipe;
import com.example.paragonPioneerBackend.Exception.EntityNotFoundException;
import com.example.paragonPioneerBackend.Repository.GoodRepository;
import com.example.paragonPioneerBackend.Repository.RecipeRepository;
import com.example.paragonPioneerBackend.Service.generic.SlugableService;
import com.example.paragonPioneerBackend.Util.ServiceUtil;
import com.example.paragonPioneerBackend.Util.SlugUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Service class for managing recipes in the application. It provides methods for creating,
 * updating, and retrieving recipes, with a focus on manipulating Recipe entities and
 * interacting with the database via the RecipeRepository. Additionally, it utilizes
 * GoodRepository for operations related to the Good entities that are part of the recipes.
 */
@org.springframework.stereotype.Service()
public class RecipeService extends SlugableService<Recipe, RecipeRepository, RecipeInput> {

    private final GoodRepository goodRepository;

    /**
     * Constructor to autowire the RecipeRepository and GoodRepository, enabling
     * database operations for recipes and associated goods.
     *
     * @param repository     The RecipeRepository for recipe database operations.
     * @param goodRepository The GoodRepository for good database operations.
     */
    @Autowired
    public RecipeService(RecipeRepository repository, GoodRepository goodRepository) {
        super(repository);
        this.goodRepository = goodRepository;
    }

    /**
     * This method is used to map a RecipeInput DTO to a Recipe entity.
     * It uses the builder pattern to create a new Recipe entity and sets its input and output properties based on the DTO.
     * The input and output goods are retrieved from the GoodRepository using the PatchUtil.getHelper method.
     *
     * @param recipeInput The DTO that contains the new values for the Recipe entity.
     * @return The newly created Recipe entity.
     */
    @Override
    @Transactional
    public Recipe mapToEntity(RecipeInput recipeInput) {
        return Recipe.builder()
                .input1(ServiceUtil.ifErrorThenNull(good -> ServiceUtil.getHelper(good, goodRepository), recipeInput.getGood_1()))
                .quantityOfInput1(recipeInput.getQuantityOfGood_1())
                .input2(ServiceUtil.ifErrorThenNull(good -> ServiceUtil.getHelper(good, goodRepository), recipeInput.getGood_2()))
                .quantityOfInput2(recipeInput.getQuantityOfGood_2())
                .input3(ServiceUtil.ifErrorThenNull(good -> ServiceUtil.getHelper(good, goodRepository), recipeInput.getGood_3()))
                .quantityOfInput3(recipeInput.getQuantityOfGood_3())
                .input4(ServiceUtil.ifErrorThenNull(good -> ServiceUtil.getHelper(good, goodRepository), recipeInput.getGood_4()))
                .quantityOfInput4(recipeInput.getQuantityOfGood_4())
                .input5(ServiceUtil.ifErrorThenNull(good -> ServiceUtil.getHelper(good, goodRepository), recipeInput.getGood_5()))
                .quantityOfInput5(recipeInput.getQuantityOfGood_5())
                .input6(ServiceUtil.ifErrorThenNull(good -> ServiceUtil.getHelper(good, goodRepository), recipeInput.getGood_6()))
                .quantityOfInput6(recipeInput.getQuantityOfGood_6())
                .input7(ServiceUtil.ifErrorThenNull(good -> ServiceUtil.getHelper(good, goodRepository), recipeInput.getGood_7()))
                .quantityOfInput7(recipeInput.getQuantityOfGood_7())
                .input8(ServiceUtil.ifErrorThenNull(good -> ServiceUtil.getHelper(good, goodRepository), recipeInput.getGood_8()))
                .quantityOfInput8(recipeInput.getQuantityOfGood_8())
                .input9(ServiceUtil.ifErrorThenNull(good -> ServiceUtil.getHelper(good, goodRepository), recipeInput.getGood_9()))
                .quantityOfInput9(recipeInput.getQuantityOfGood_9())
                .input10(ServiceUtil.ifErrorThenNull(good -> ServiceUtil.getHelper(good, goodRepository), recipeInput.getGood_10()))
                .quantityOfInput10(recipeInput.getQuantityOfGood_10())
                .output(ServiceUtil.ifErrorThenNull(good -> ServiceUtil.getHelper(good, goodRepository), recipeInput.getOutputGood()))
                .slug(SlugUtil.createSlug(ServiceUtil.getHelper(recipeInput.getOutputGood(), goodRepository).getName()))
                .name(ServiceUtil.getHelper(recipeInput.getOutputGood(), goodRepository).getName())
                .build();
    }

    /**
     * This method is used to update the properties of a Recipe entity based on the provided DTO.
     * It updates the input and output properties of the entity to update.
     * The input and output properties are updated using the PatchUtil.patchHelper method, which checks if the new value is null.
     * If the new value is not null, it replaces the old value. If it is null, the old value is kept.
     * The method is marked as @Transactional, meaning it is part of a database transaction.
     *
     * @param entityToUpdate The original Recipe entity that might be updated.
     * @param recipeInput    The DTO that contains the new values for the Recipe entity.
     * @return The updated Recipe entity.
     */
    @Override
    public Recipe patch(Recipe entityToUpdate, RecipeInput recipeInput) {
        entityToUpdate.setInput1(ServiceUtil.patchHelper(entityToUpdate.getInput1(), recipeInput.getGood_1(), goodRepository));
        entityToUpdate.setInput2(ServiceUtil.patchHelper(entityToUpdate.getInput2(), recipeInput.getGood_2(), goodRepository));
        entityToUpdate.setInput3(ServiceUtil.patchHelper(entityToUpdate.getInput3(), recipeInput.getGood_3(), goodRepository));
        entityToUpdate.setInput4(ServiceUtil.patchHelper(entityToUpdate.getInput4(), recipeInput.getGood_4(), goodRepository));
        entityToUpdate.setInput5(ServiceUtil.patchHelper(entityToUpdate.getInput5(), recipeInput.getGood_5(), goodRepository));
        entityToUpdate.setInput6(ServiceUtil.patchHelper(entityToUpdate.getInput6(), recipeInput.getGood_6(), goodRepository));
        entityToUpdate.setInput7(ServiceUtil.patchHelper(entityToUpdate.getInput7(), recipeInput.getGood_7(), goodRepository));
        entityToUpdate.setInput8(ServiceUtil.patchHelper(entityToUpdate.getInput8(), recipeInput.getGood_8(), goodRepository));
        entityToUpdate.setInput9(ServiceUtil.patchHelper(entityToUpdate.getInput9(), recipeInput.getGood_9(), goodRepository));
        entityToUpdate.setInput10(ServiceUtil.patchHelper(entityToUpdate.getInput10(), recipeInput.getGood_10(), goodRepository));
        entityToUpdate.setOutput(ServiceUtil.patchHelper(entityToUpdate.getOutput(), recipeInput.getOutputGood(), goodRepository));
        entityToUpdate.setQuantityOfInput1(ServiceUtil.patchHelper(entityToUpdate.getQuantityOfInput1(), recipeInput.getQuantityOfGood_1()));
        entityToUpdate.setQuantityOfInput2(ServiceUtil.patchHelper(entityToUpdate.getQuantityOfInput2(), recipeInput.getQuantityOfGood_2()));
        entityToUpdate.setQuantityOfInput3(ServiceUtil.patchHelper(entityToUpdate.getQuantityOfInput3(), recipeInput.getQuantityOfGood_3()));
        entityToUpdate.setQuantityOfInput4(ServiceUtil.patchHelper(entityToUpdate.getQuantityOfInput4(), recipeInput.getQuantityOfGood_4()));
        entityToUpdate.setQuantityOfInput5(ServiceUtil.patchHelper(entityToUpdate.getQuantityOfInput5(), recipeInput.getQuantityOfGood_5()));
        entityToUpdate.setQuantityOfInput6(ServiceUtil.patchHelper(entityToUpdate.getQuantityOfInput6(), recipeInput.getQuantityOfGood_6()));
        entityToUpdate.setQuantityOfInput7(ServiceUtil.patchHelper(entityToUpdate.getQuantityOfInput7(), recipeInput.getQuantityOfGood_7()));
        entityToUpdate.setQuantityOfInput8(ServiceUtil.patchHelper(entityToUpdate.getQuantityOfInput8(), recipeInput.getQuantityOfGood_8()));
        entityToUpdate.setQuantityOfInput9(ServiceUtil.patchHelper(entityToUpdate.getQuantityOfInput9(), recipeInput.getQuantityOfGood_9()));
        entityToUpdate.setQuantityOfInput10(ServiceUtil.patchHelper(entityToUpdate.getQuantityOfInput10(), recipeInput.getQuantityOfGood_10()));
        return entityToUpdate;
    }

    public Recipe findByOutputId(UUID id) {
        return repository.findByOutputIdIs(id).orElseThrow(() -> new EntityNotFoundException("Recipe", id));
    }
}