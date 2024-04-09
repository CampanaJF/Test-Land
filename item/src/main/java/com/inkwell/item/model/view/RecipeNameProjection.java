package com.inkwell.item.model.view;

import org.springframework.beans.factory.annotation.Value;

public interface RecipeNameProjection {

    @Value("#{target.name}")
    String getName();

    void setName(String name);
}
