package com.example.recipes.service;

import com.example.recipes.model.Recipe;
import com.example.recipes.repository.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RecipeServiceTest {

    @Mock
    private RecipeRepository recipeRepository;

    @InjectMocks
    private RecipeService recipeService;

    private Recipe recipe1, recipe2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        recipe1 = new Recipe(1L, "Pasta", Arrays.asList("Flour", "Eggs"),
                Arrays.asList("Mix", "Boil"), 10, 20, 2, "Easy", "Italian",
                400, Arrays.asList("Dinner"), 101L, "image_url", 4.5, 20, Arrays.asList("Meal"));

        recipe2 = new Recipe(2L, "Pizza", Arrays.asList("Dough", "Cheese"),
                Arrays.asList("Prepare", "Bake"), 15, 30, 4, "Medium", "Italian",
                600, Arrays.asList("Lunch"), 102L, "image_url", 4.7, 50, Arrays.asList("Meal"));
    }

    @Test
    void testGetAllRecipes() {
        when(recipeRepository.findAll()).thenReturn(Arrays.asList(recipe1, recipe2));

        List<Recipe> result = recipeService.getAllRecipes();
        assertEquals(2, result.size());
    }

    @Test
    void testGetRecipeById() {
        when(recipeRepository.findById(1L)).thenReturn(Optional.of(recipe1));

        Recipe result = recipeService.getRecipeById(1L);
        assertEquals("Pasta", result.getName());
    }

    @Test
    void testGetRecipesByCuisine() {
        when(recipeRepository.findByCuisine("Italian")).thenReturn(Arrays.asList(recipe1, recipe2));

        List<Recipe> result = recipeService.getRecipesByCuisine("Italian");
        assertEquals(2, result.size());
    }
}
