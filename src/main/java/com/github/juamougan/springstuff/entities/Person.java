package com.github.juamougan.springstuff.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

  @NotBlank(message = "Name is mandatory")
  @Size(min = 2, max = 30)
  private String name;

  @NotNull(message = "Age is mandatory")
  @Min(18)
  @Max(200)             // What about Mirtha? :D
  private Integer age;

  @Pattern(regexp = "[_a-zA-Z1-9]+(\\.[A-Za-z0-9]*)*@[A-Za-z0-9]+\\.[A-Za-z0-9]+(\\.[A-Za-z0-9]*)*", message = "Invalid email")
  private String email;

}
