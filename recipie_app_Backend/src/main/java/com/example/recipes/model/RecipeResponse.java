package com.example.recipes.model;

import lombok.Data;
import java.util.List;

@Data
public class RecipeResponse {
    private List<Recipe> recipes;  // This matches the JSON response structure
}
