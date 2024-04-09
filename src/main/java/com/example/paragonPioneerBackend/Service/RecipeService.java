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
    public Recipe mapToEntity(RecipeInput recipeInput) {
        return Recipe.builder()
                .input1(ServiceUtil.ifErrorThenNull(good -> ServiceUtil.getHelper(good, goodRepository), recipeInput.getInput1()))
                .quantityOfInput1(recipeInput.getQuantityOfInput1())
                .input2(ServiceUtil.ifErrorThenNull(good -> ServiceUtil.getHelper(good, goodRepository), recipeInput.getInput2()))
                .quantityOfInput2(recipeInput.getQuantityOfInput2())
                .input3(ServiceUtil.ifErrorThenNull(good -> ServiceUtil.getHelper(good, goodRepository), recipeInput.getInput3()))
                .quantityOfInput3(recipeInput.getQuantityOfInput3())
                .input4(ServiceUtil.ifErrorThenNull(good -> ServiceUtil.getHelper(good, goodRepository), recipeInput.getInput4()))
                .quantityOfInput4(recipeInput.getQuantityOfInput4())
                .input5(ServiceUtil.ifErrorThenNull(good -> ServiceUtil.getHelper(good, goodRepository), recipeInput.getInput5()))
                .quantityOfInput5(recipeInput.getQuantityOfInput5())
                .input6(ServiceUtil.ifErrorThenNull(good -> ServiceUtil.getHelper(good, goodRepository), recipeInput.getInput6()))
                .quantityOfInput6(recipeInput.getQuantityOfInput6())
                .input7(ServiceUtil.ifErrorThenNull(good -> ServiceUtil.getHelper(good, goodRepository), recipeInput.getInput7()))
                .quantityOfInput7(recipeInput.getQuantityOfInput7())
                .input8(ServiceUtil.ifErrorThenNull(good -> ServiceUtil.getHelper(good, goodRepository), recipeInput.getInput8()))
                .quantityOfInput8(recipeInput.getQuantityOfInput8())
                .input9(ServiceUtil.ifErrorThenNull(good -> ServiceUtil.getHelper(good, goodRepository), recipeInput.getInput9()))
                .quantityOfInput9(recipeInput.getQuantityOfInput9())
                .input10(ServiceUtil.ifErrorThenNull(good -> ServiceUtil.getHelper(good, goodRepository), recipeInput.getInput10()))
                .quantityOfInput10(recipeInput.getQuantityOfInput10())
                .output(ServiceUtil.ifErrorThenNull(good -> ServiceUtil.getHelper(good, goodRepository), recipeInput.getOutput()))
                .slug(SlugUtil.createSlug(ServiceUtil.getHelperNoNull(recipeInput.getOutput(), goodRepository).getName()))
                .name(ServiceUtil.getHelperNoNull(recipeInput.getOutput(), goodRepository).getName())
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
        entityToUpdate.setInput1(ServiceUtil.patchHelper(entityToUpdate.getInput1(), recipeInput.getInput1(), goodRepository));
        entityToUpdate.setInput2(ServiceUtil.patchHelper(entityToUpdate.getInput2(), recipeInput.getInput2(), goodRepository));
        entityToUpdate.setInput3(ServiceUtil.patchHelper(entityToUpdate.getInput3(), recipeInput.getInput3(), goodRepository));
        entityToUpdate.setInput4(ServiceUtil.patchHelper(entityToUpdate.getInput4(), recipeInput.getInput4(), goodRepository));
        entityToUpdate.setInput5(ServiceUtil.patchHelper(entityToUpdate.getInput5(), recipeInput.getInput5(), goodRepository));
        entityToUpdate.setInput6(ServiceUtil.patchHelper(entityToUpdate.getInput6(), recipeInput.getInput6(), goodRepository));
        entityToUpdate.setInput7(ServiceUtil.patchHelper(entityToUpdate.getInput7(), recipeInput.getInput7(), goodRepository));
        entityToUpdate.setInput8(ServiceUtil.patchHelper(entityToUpdate.getInput8(), recipeInput.getInput8(), goodRepository));
        entityToUpdate.setInput9(ServiceUtil.patchHelper(entityToUpdate.getInput9(), recipeInput.getInput9(), goodRepository));
        entityToUpdate.setInput10(ServiceUtil.patchHelper(entityToUpdate.getInput10(), recipeInput.getInput10(), goodRepository));
        entityToUpdate.setOutput(ServiceUtil.patchHelper(entityToUpdate.getOutput(), recipeInput.getOutput(), goodRepository));
        entityToUpdate.setQuantityOfInput1(ServiceUtil.patchHelper(entityToUpdate.getQuantityOfInput1(), recipeInput.getQuantityOfInput1()));
        entityToUpdate.setQuantityOfInput2(ServiceUtil.patchHelper(entityToUpdate.getQuantityOfInput2(), recipeInput.getQuantityOfInput2()));
        entityToUpdate.setQuantityOfInput3(ServiceUtil.patchHelper(entityToUpdate.getQuantityOfInput3(), recipeInput.getQuantityOfInput3()));
        entityToUpdate.setQuantityOfInput4(ServiceUtil.patchHelper(entityToUpdate.getQuantityOfInput4(), recipeInput.getQuantityOfInput4()));
        entityToUpdate.setQuantityOfInput5(ServiceUtil.patchHelper(entityToUpdate.getQuantityOfInput5(), recipeInput.getQuantityOfInput5()));
        entityToUpdate.setQuantityOfInput6(ServiceUtil.patchHelper(entityToUpdate.getQuantityOfInput6(), recipeInput.getQuantityOfInput6()));
        entityToUpdate.setQuantityOfInput7(ServiceUtil.patchHelper(entityToUpdate.getQuantityOfInput7(), recipeInput.getQuantityOfInput7()));
        entityToUpdate.setQuantityOfInput8(ServiceUtil.patchHelper(entityToUpdate.getQuantityOfInput8(), recipeInput.getQuantityOfInput8()));
        entityToUpdate.setQuantityOfInput9(ServiceUtil.patchHelper(entityToUpdate.getQuantityOfInput9(), recipeInput.getQuantityOfInput9()));
        entityToUpdate.setQuantityOfInput10(ServiceUtil.patchHelper(entityToUpdate.getQuantityOfInput10(), recipeInput.getQuantityOfInput10()));
        return entityToUpdate;
    }

    public Recipe findByOutputId(UUID id) {
        return repository.findByOutputIdIs(id).orElseThrow(() -> new EntityNotFoundException("Recipe", id));
    }
}