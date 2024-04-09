package com.inkwell.item.service;

import com.inkwell.item.model.Recipe;
import com.inkwell.item.model.view.RecipeIngredientsProjection;
import com.inkwell.item.model.view.RecipeNameProjection;

import java.util.List;

public interface RecipeService {

    List<Recipe> getAll();

    RecipeIngredientsProjection getRecipe(Integer id);

    List<RecipeNameProjection> getAllNames();

    List<RecipeNameProjection> searchByName(String searchField);

    List<RecipeNameProjection> searchByProfession(String searchField);

    List<RecipeNameProjection> searchByRarity(String searchField);

    List<Recipe> filterByAmountOfMaterials(Integer amount, Boolean lessOrMore);


}
