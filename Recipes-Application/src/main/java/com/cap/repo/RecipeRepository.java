package com.cap.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cap.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Integer>{

}
