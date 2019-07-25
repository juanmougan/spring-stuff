package com.github.juamougan.springstuff.entities;

import com.github.juamougan.springstuff.validation.PersonExistingConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

  @NotNull(message = "ID is mandatory")
  private Long id;

  @NotBlank(message = "Name is mandatory")
  @Size(min = 2, max = 30)
  @PersonExistingConstraint
  private String name;

  @NotNull(message = "Age is mandatory")
  @Min(18)
  @Max(200)             // What about Mirtha? :D
  private Integer age;

  @Pattern(regexp = "[_a-zA-Z1-9]+(\\.[A-Za-z0-9]*)*@[A-Za-z0-9]+\\.[A-Za-z0-9]+(\\.[A-Za-z0-9]*)*", message = "Invalid email")
  private String email;

}
