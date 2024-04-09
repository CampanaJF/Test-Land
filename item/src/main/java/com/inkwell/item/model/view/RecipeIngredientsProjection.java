package com.inkwell.item.model.view;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public interface RecipeIngredientsProjection {

    @Value("#{target.name}")
    String getName();

    @Value("#{target.ingredients}")
    List<IngredientsProjection>  getIngredients();

    void setName(String name);

    void setIngredients(List<IngredientsProjection> ingredients);

}
