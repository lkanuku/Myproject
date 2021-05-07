package com.cap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.model.Recipe;
import com.cap.repo.RecipeRepository;
@Service
public class RecipeServiceImpl implements IRecipeService{
	
    @Autowired
	private RecipeRepository repo;  
	
	@Override
	public Integer saveRecipe(Recipe recipe) {
		recipe=repo.save(recipe);
		Integer recipeId=recipe.getRecipeId();
		return recipeId;
	}

	@Override
	public void deleteRecipe(Integer recipeId) {
     repo.deleteById(recipeId);		
	}

	@Override
	public Recipe getRecipeById(Integer recipeId) {
		Optional<Recipe> recipe = repo.findById(recipeId);
		if(recipe.isPresent()) {
			return recipe.get();
		}else {
			return new Recipe();
		}
		}

	@Override
	public List<Recipe> getAllRecipes() {
		List<Recipe> recipes = repo.findAll();
		return recipes;
	}

	@Override
	public boolean isRecipeExist(Integer id) {
		
		return repo.existsById(id);
	}

}
