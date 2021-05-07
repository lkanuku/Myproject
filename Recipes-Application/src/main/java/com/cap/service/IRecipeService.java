package com.cap.service;

import java.util.List;

import com.cap.model.Recipe;

public interface IRecipeService {
	
	public Integer saveRecipe(Recipe recipe);
	public void deleteRecipe(Integer recipeId);
	public Recipe getRecipeById(Integer recipeId);
	public List<Recipe> getAllRecipes();
	public boolean isRecipeExist(Integer id);

}
