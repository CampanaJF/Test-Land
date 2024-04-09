package com.inkwell.item.repository;

import com.inkwell.item.model.Recipe;
import com.inkwell.item.model.view.RecipeIngredientsProjection;
import com.inkwell.item.model.view.RecipeNameProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RecipeJpaRepository extends JpaRepository<Recipe, Integer> {

    Optional<RecipeIngredientsProjection> getRecipeById(Integer id);

    @Query(
            nativeQuery = true,
            value = "select r.name from recipes r; "
    )
    List<RecipeNameProjection> findAllRecipes();

    @Query(
            nativeQuery = true,
            value = "select r.name from recipes r where r.name like %:name% ;"
    )
    List<RecipeNameProjection> searchRecipesByName(@Param("name")String search);

    @Query(
            nativeQuery = true,
            value = "select r.name from recipes r where r.profession like :profession ;"
    )
    List<RecipeNameProjection> searchRecipesByProfession(@Param("profession") String search);

    @Query(
            nativeQuery = true,
            value = "select r.name from recipes r where r.rarity like :rarity ;"
    )
    List<RecipeNameProjection> searchRecipesByRarity(@Param("rarity") String search);

}
