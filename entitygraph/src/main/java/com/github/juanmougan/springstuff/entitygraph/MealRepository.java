package com.github.juanmougan.springstuff.entitygraph;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Long> {
    @EntityGraph(value = "Meal.ingredients")
    Meal findByName(String name);

    @EntityGraph(attributePaths = {"ingredients"})
    Meal findByType(MealType type);
}
