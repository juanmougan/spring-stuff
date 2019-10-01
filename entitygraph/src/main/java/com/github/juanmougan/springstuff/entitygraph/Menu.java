package com.github.juanmougan.springstuff.entitygraph;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Menu {
    @Id
    private long id;
    private Set<Meal> meals;
}
