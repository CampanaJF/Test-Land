package com.inkwell.item.controller.dto;

public record RecipeSearchFilter(
        Integer amount,
        Boolean lessOrMore
) {
}
