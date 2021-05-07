package com.cap.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Recipe {
	@Id
	@GeneratedValue
	private Integer recipeId;
	private String recipeName;
	private String recipeType;
	private String ingredients;
	public Recipe() {
		super();
	}
	
	public Recipe(Integer recipeId, String recipeName, String recipeType, String ingredients) {
		super();
		this.recipeId = recipeId;
		this.recipeName = recipeName;
		this.recipeType = recipeType;
		this.ingredients = ingredients;
	}
	 
	
	
	

}
