package com.github.juanmougan.springstuff.entitygraph;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
// Example using 'NamedEntityGraph'
@NamedEntityGraph(name = "Meal.ingredients",            // TODO use Lombok's 'Fields' here
        attributeNodes = @NamedAttributeNode("ingredients")
)
public class Meal {
    @Id
    private long id;
    private String name;
    private String description;
    private MealType type;
    @ManyToMany
    private Set<Ingredient> ingredients;
    private int cookTime;
}
