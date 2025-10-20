package com.ucacue.AppCafeteria.persistence.mapper;

import com.ucacue.AppCafeteria.domain.model.Recipe;
import com.ucacue.AppCafeteria.persistence.entity.RecipeEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RecipeMapper {
    // Entity to Model
    Recipe toRecipe(RecipeEntity recipeEntity);
    List<Recipe> toRecipes(List<RecipeEntity> recipeEntities);

    // Model to Entity
    RecipeEntity toRecipeEntity(Recipe recipe);
    List<RecipeEntity> toRecipesEntity(List<Recipe> recipes);
}
