package com.example.recipes.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recipe {
    @Id
    private Long id;

    private String name;

    @ElementCollection
    private List<String> ingredients;

    @ElementCollection
    private List<String> instructions;

    private int prepTimeMinutes;
    private int cookTimeMinutes;
    private int servings;
    private String difficulty;
    private String cuisine;
    private int caloriesPerServing;

    @ElementCollection
    private List<String> tags;

    private Long userId;
    private String image;
    private double rating;
    private int reviewCount;

    @ElementCollection
    private List<String> mealType;
}
