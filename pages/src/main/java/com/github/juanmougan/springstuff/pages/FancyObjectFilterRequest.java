package com.github.juanmougan.springstuff.pages;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class FancyObjectFilterRequest {
  private String nameEqualTo;
  private LocalDateTime createdAfter;
}
