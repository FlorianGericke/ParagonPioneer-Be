package com.example.paragonPioneerBackend.Service;

import com.example.paragonPioneerBackend.Dto.RecipeDTO;
import com.example.paragonPioneerBackend.Entity.Recipe;
import com.example.paragonPioneerBackend.Repository.GoodRepository;
import com.example.paragonPioneerBackend.Repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component(value = "recipeService")
public class RecipeService extends BaseService<Recipe, RecipeRepository, RecipeDTO> {

    private final GoodRepository goodRepository;

    @Autowired
    public RecipeService(RecipeRepository repository, GoodRepository goodRepository) {
        super(repository);
        this.goodRepository = goodRepository;
    }

    @Override
    public Recipe post(RecipeDTO recipeDTO) {
        return repository.save(Recipe.builder()
                .input1(goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 1)).orElse(null))
                .input2(goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 2)).orElse(null))
                .input3(goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 3)).orElse(null))
                .input4(goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 4)).orElse(null))
                .input5(goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 5)).orElse(null))
                .input6(goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 6)).orElse(null))
                .input7(goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 7)).orElse(null))
                .input8(goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 8)).orElse(null))
                .input9(goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 9)).orElse(null))
                .input10(goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 10)).orElse(null))
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
                .output(goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 11)).orElse(null))
                .build());
    }

    @Override
    public Recipe putPatch(Recipe original, RecipeDTO recipeDTO) {
        original.setInput1(original.getInput1().getId() != getUUIDFromGoodNumber(recipeDTO, 1) ? goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 1)).orElse(null) : original.getInput1());
        original.setInput2(original.getInput2().getId() != getUUIDFromGoodNumber(recipeDTO, 2) ? goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 2)).orElse(null) : original.getInput2());
        original.setInput3(original.getInput3().getId() != getUUIDFromGoodNumber(recipeDTO, 3) ? goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 3)).orElse(null) : original.getInput3());
        original.setInput4(original.getInput4().getId() != getUUIDFromGoodNumber(recipeDTO, 4) ? goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 4)).orElse(null) : original.getInput4());
        original.setInput5(original.getInput5().getId() != getUUIDFromGoodNumber(recipeDTO, 5) ? goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 5)).orElse(null) : original.getInput5());
        original.setInput6(original.getInput6().getId() != getUUIDFromGoodNumber(recipeDTO, 6) ? goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 6)).orElse(null) : original.getInput6());
        original.setInput7(original.getInput7().getId() != getUUIDFromGoodNumber(recipeDTO, 7) ? goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 7)).orElse(null) : original.getInput7());
        original.setInput8(original.getInput8().getId() != getUUIDFromGoodNumber(recipeDTO, 8) ? goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 8)).orElse(null) : original.getInput8());
        original.setInput9(original.getInput9().getId() != getUUIDFromGoodNumber(recipeDTO, 9) ? goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 9)).orElse(null) : original.getInput9());
        original.setInput10(original.getInput10().getId() != getUUIDFromGoodNumber(recipeDTO, 10) ? goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 10)).orElse(null) : original.getInput10());

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


        original.setOutput(original.getOutput().getId() != getUUIDFromGoodNumber(recipeDTO, 11) ? goodRepository.findById(getUUIDFromGoodNumber(recipeDTO, 11)).orElse(null) : original.getOutput());

        return original;
    }

    private UUID getUUIDFromGoodNumber(RecipeDTO recipeDTO, int num) {
        return switch (num) {
            case 1 ->
                    recipeDTO.getInput1() != null ? recipeDTO.getInput1() : goodRepository.findByNameIs(recipeDTO.getInput1Name()).getId();
            case 2 ->
                    recipeDTO.getInput2() != null ? recipeDTO.getInput2() : goodRepository.findByNameIs(recipeDTO.getInput2Name()).getId();
            case 3 ->
                    recipeDTO.getInput3() != null ? recipeDTO.getInput3() : goodRepository.findByNameIs(recipeDTO.getInput3Name()).getId();
            case 4 ->
                    recipeDTO.getInput4() != null ? recipeDTO.getInput4() : goodRepository.findByNameIs(recipeDTO.getInput4Name()).getId();
            case 5 ->
                    recipeDTO.getInput5() != null ? recipeDTO.getInput5() : goodRepository.findByNameIs(recipeDTO.getInput5Name()).getId();
            case 6 ->
                    recipeDTO.getInput6() != null ? recipeDTO.getInput6() : goodRepository.findByNameIs(recipeDTO.getInput6Name()).getId();
            case 7 ->
                    recipeDTO.getInput7() != null ? recipeDTO.getInput7() : goodRepository.findByNameIs(recipeDTO.getInput7Name()).getId();
            case 8 ->
                    recipeDTO.getInput8() != null ? recipeDTO.getInput8() : goodRepository.findByNameIs(recipeDTO.getInput8Name()).getId();
            case 9 ->
                    recipeDTO.getInput9() != null ? recipeDTO.getInput9() : goodRepository.findByNameIs(recipeDTO.getInput9Name()).getId();
            case 10 ->
                    recipeDTO.getInput10() != null ? recipeDTO.getInput10() : goodRepository.findByNameIs(recipeDTO.getInput10Name()).getId();
            case 11 ->
                    recipeDTO.getOutput() != null ? recipeDTO.getOutput() : goodRepository.findByNameIs(recipeDTO.getOutputName()).getId();
            default -> null;
        };
    }
}