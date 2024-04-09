package com.inkwell.item.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inkwell.item.controller.dto.RecipeDto;
import com.inkwell.item.controller.dto.RecipeSearchFilter;
import com.inkwell.item.exception.RecipeNotFoundException;
import com.inkwell.item.model.Recipe;
import com.inkwell.item.model.view.RecipeIngredientsProjection;
import com.inkwell.item.model.view.RecipeNameProjection;
import com.inkwell.item.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/item/v1")
public class RecipeController {

    private final RecipeService recipeService;

    private final ObjectMapper mapper;

    //TODO
    // move jpa native queries to their own file <-> why? they aren't complex enough yet
    // turn those queries into procedures maybe? <-> go deeper first
    // filter recipes that use materials of a certain rarity
    // filter recipes by the total cost of their materials

    @GetMapping("/test/{text}")
    public ResponseEntity<String> testText(@PathVariable("text") String text){

        return ResponseEntity.ok(text + "yippie");
    }

    @GetMapping("/{recipeId}")
    public ResponseEntity<RecipeIngredientsProjection> get(
            @PathVariable("recipeId") Integer recipeId){
        try{
            return ResponseEntity.ok(recipeService.getRecipe(recipeId));
        }catch(RecipeNotFoundException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    @GetMapping
    public ResponseEntity<List<RecipeNameProjection>> getAll(){
        return ResponseEntity.ok(recipeService.getAllNames());
    }

    @GetMapping("search/name/{search}")
    public ResponseEntity<List<RecipeNameProjection>> searchByName(
            @PathVariable("search") String search) {
        return ResponseEntity.ok(recipeService.searchByName(search));
    }

    @GetMapping("search/profession/{search}")
    public ResponseEntity<List<RecipeNameProjection>> searchByProfession(
            @PathVariable("search") String search) {
        return ResponseEntity.ok(recipeService.searchByProfession(search));
    }

    @GetMapping("search/rarity/{search}")
    public ResponseEntity<List<RecipeNameProjection>> searchByRarity(
            @PathVariable("search") String search) {
        return ResponseEntity.ok(recipeService.searchByRarity(search));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<RecipeDto>> filter(
            @RequestBody RecipeSearchFilter recipeSearchFilter) {

        List<Recipe> res = recipeService
                .filterByAmountOfMaterials(recipeSearchFilter.amount(),recipeSearchFilter.lessOrMore());

        return ResponseEntity.ok(mapper.convertValue(res, new TypeReference<List<RecipeDto>>() {}));
    }


}
