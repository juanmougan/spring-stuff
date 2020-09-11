package com.github.juanmougan.springstuff.pages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FancyObject {
  private String name;
  private LocalDateTime createdAt;
}
