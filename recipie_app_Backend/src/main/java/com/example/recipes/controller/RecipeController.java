package com.example.recipes.controller;

import com.example.recipes.model.Recipe;
import com.example.recipes.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    // get List of all recipes
    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    // Get recipe by ID
    @GetMapping("/{id}")
    public Recipe getRecipeById(@PathVariable Long id) {
        return recipeService.getRecipeById(id);
    }

    // get recipes by cuisine
    @GetMapping("/cuisine/{cuisine}")
    public List<Recipe> getRecipesByCuisine(@PathVariable String cuisine) {
        return recipeService.getRecipesByCuisine(cuisine);
    }

    //  get sorted recipes by calories (asc/desc)
    @GetMapping("/sorted")
    public List<Recipe> getSortedRecipes(@RequestParam(defaultValue = "asc") String order) {
        return recipeService.getSortedRecipesByCalories(order);
    }

    // Load recipes from external API----> https://dummyjson.com/recipes
    @PostMapping("/load")
    public String loadRecipes() {
        recipeService.loadRecipesFromExternalAPI();
        return "Recipes loaded successfully!";
    }
}
