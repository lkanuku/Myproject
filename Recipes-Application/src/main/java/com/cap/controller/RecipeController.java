package com.cap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cap.model.Recipe;
import com.cap.service.IRecipeService;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
	@Autowired
	private IRecipeService service;
	
	@PostMapping("/register")
	public ResponseEntity<?> saveRecipe(@RequestBody Recipe recipe){
		ResponseEntity<?> response=null;
		try {
			Integer stdId=service.saveRecipe(recipe);
			response=new ResponseEntity<String>(stdId+"-Inserted", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response=new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> showOneRecipe(@PathVariable Integer id) {
		ResponseEntity<?> response=null;
		boolean exist=service.isRecipeExist(id);
		if(exist) {
			Recipe s=service.getRecipeById(id);
			response=new ResponseEntity<Recipe>(s, HttpStatus.OK);
		}else {
			response=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> showAllRecipes() {
		ResponseEntity<?> response=null;
		List<Recipe> recipes=service.getAllRecipes();
		if(recipes!=null && !recipes.isEmpty()) {
			response=new ResponseEntity<List<Recipe>>(recipes, HttpStatus.OK);
		}else {
			response=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteRecipe(@PathVariable Integer id) {
		ResponseEntity<?> response=null;
		boolean exist=service.isRecipeExist(id);
		if(exist) {
			service.deleteRecipe(id);
			response=new ResponseEntity<String>(id+"-Removed", HttpStatus.OK);
		}else {
			response=new ResponseEntity<String>("Recipe NOT FOUND",HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	
	@PutMapping("/edit")
	public ResponseEntity<?> editProduct(@RequestBody Recipe recipe) {
		ResponseEntity<?> response=null;
		Integer id=recipe.getRecipeId();
		boolean exist=service.isRecipeExist(id);
		if(exist) {
			service.saveRecipe(recipe);
			response=new ResponseEntity<String>(id+"-Updated", HttpStatus.OK);
		}else {
			response=new ResponseEntity<String>("Recipe NOT FOUND",HttpStatus.BAD_REQUEST);
		}
		return response;
	}

}
