package com.inkwell.item.service.implementation;

import com.inkwell.item.exception.RecipeNotFoundException;
import com.inkwell.item.model.Recipe;
import com.inkwell.item.model.view.RecipeIngredientsProjection;
import com.inkwell.item.model.view.RecipeNameProjection;
import com.inkwell.item.repository.RecipeJpaRepository;
import com.inkwell.item.service.RecipeService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Log4j2
public class RecipeServiceImpl implements RecipeService {

    private final RecipeJpaRepository recipeJpaRepository;

    @Override
    public List<Recipe> getAll() {
        return recipeJpaRepository.findAll();
    }

    @Override
    public RecipeIngredientsProjection getRecipe(Integer recipeId) throws RecipeNotFoundException{
        return recipeJpaRepository.getRecipeById(recipeId)
                .orElseThrow(() -> {
                    log.error(String.format("Recipe not found for id: %s", recipeId));
                    return new RecipeNotFoundException(String.format("Recipe not found for id: %s", recipeId));
                });
    }

    @Override
    public List<RecipeNameProjection> getAllNames() {
        return recipeJpaRepository.findAllRecipes();
    }

    @Override
    public List<RecipeNameProjection> searchByName(String searchField) {
        return recipeJpaRepository.searchRecipesByName(searchField);
    }

    @Override
    public List<RecipeNameProjection> searchByProfession(String searchField) {
        return recipeJpaRepository.searchRecipesByProfession(searchField);
    }

    @Override
    public List<RecipeNameProjection> searchByRarity(String searchField) {
        return recipeJpaRepository.searchRecipesByRarity(searchField);
    }

    // where to filter?
    @Override
    public List<Recipe> filterByAmountOfMaterials(Integer amount,Boolean lessOrMore) {
        List<Recipe> recipes = getAll();

        if(!lessOrMore){
            return removeRecipesWithMoreIngredients(amount, recipes);
        }

        return removeRecipesWithLessIngredients(amount, recipes);
    }

    private List<Recipe> removeRecipesWithMoreIngredients(Integer amount,List<Recipe> recipes) {

        recipes.removeIf(recipe -> recipe.getTotalMaterials() > amount);

        return recipes;
    }

    private List<Recipe> removeRecipesWithLessIngredients(Integer amount,List<Recipe> recipes) {

        recipes.removeIf(recipe -> recipe.getTotalMaterials() < amount);

        return recipes;
    }


}
