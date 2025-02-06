package com.example.recipes.service;

import com.example.recipes.model.Recipe;
import com.example.recipes.model.RecipeResponse;
import com.example.recipes.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    private final String EXTERNAL_API = "https://dummyjson.com/recipes";

    //Fetch all recipes
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    //Fetch recipe by ID
    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id).orElse(null);
    }

    // Fetch recipes by cuisine
    public List<Recipe> getRecipesByCuisine(String cuisine) {
        return recipeRepository.findByCuisine(cuisine);
    }

    // Fetch sorted recipes by calories
    public List<Recipe> getSortedRecipesByCalories(String order) {
        return order.equalsIgnoreCase("asc") ?
                recipeRepository.findAllSortedByCaloriesAsc() :
                recipeRepository.findAllSortedByCaloriesDesc();
    }

    //Load recipes from external API
    public void loadRecipesFromExternalAPI() {
        RestTemplate restTemplate = new RestTemplate();
        RecipeResponse response = restTemplate.getForObject(EXTERNAL_API, RecipeResponse.class);
        if (response != null && response.getRecipes() != null) {
            recipeRepository.saveAll(response.getRecipes());
        }
    }
}
