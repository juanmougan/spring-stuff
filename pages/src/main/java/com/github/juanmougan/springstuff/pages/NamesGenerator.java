package com.github.juanmougan.springstuff.pages;

import lombok.experimental.UtilityClass;

@UtilityClass
public class NamesGenerator {

  private final String[] FEMALE_AND_MALE_NAMES = {
      "Valeria",
      "Natalia",
      "Isabel",
      "Sara",
      "Liliana",
      "Adriana",
      "Juliana",
      "Gabriela",
      "Daniela",
      "Valentina",
      "Lila",
      "Vivian",
      "Nora",
      "Ángela",
      "Elena",
      "Clara",
      "Eliana",
      "Miranda",
      "Amanda",
      "Diana",    // 20 women, they fit on the first page
      "Daniel",
      "David",
      "Gabriel",
      "Benjamín",
      "Lucas",
      "Ángel",
      "José",
      "Adrián",
      "Sebastián",
      "Xavier",
      "Juan",
      "Luis",
      "Diego",
      "Carlos",
      "Jesús",
      "Alex",
      "Alejandro",
      "Antonio",
      "Miguel",
      "Víctor"    // 20 men, they fit on the second page
  };

  public String getName(final int index) {
    return FEMALE_AND_MALE_NAMES[index % FEMALE_AND_MALE_NAMES.length];
  }
}
