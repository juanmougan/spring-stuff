package com.github.juanmougan.springstuff.entitygraph;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ingredient {
    @Id
    private long id;
    private String name;
    private int calories;
    @ManyToMany
    private Set<Meal> meals;
}
