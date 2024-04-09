package com.inkwell.item.model.view;

import org.springframework.beans.factory.annotation.Value;

public interface MaterialProjection {

    @Value("#{target.name}")
    String getName();

    void setName(String name);


}
