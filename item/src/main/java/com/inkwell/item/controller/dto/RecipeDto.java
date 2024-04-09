package com.inkwell.item.controller.dto;

import java.util.List;

public record RecipeDto(

        String name,

        Integer totalIngredients,

        List<IngredientDto> ingredients
) {
}
