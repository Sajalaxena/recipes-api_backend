package com.example.recipes.repository;

import com.example.recipes.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    // Find recipes by cuisine
    List<Recipe> findByCuisine(String cuisine);

    // Custom query to fetch recipes sorted by calories
    @Query("SELECT r FROM Recipe r ORDER BY r.caloriesPerServing ASC")
    List<Recipe> findAllSortedByCaloriesAsc();

    @Query("SELECT r FROM Recipe r ORDER BY r.caloriesPerServing DESC")
    List<Recipe> findAllSortedByCaloriesDesc();
}
