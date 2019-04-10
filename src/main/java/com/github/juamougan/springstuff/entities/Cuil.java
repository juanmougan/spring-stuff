package com.github.juamougan.springstuff.entities;

import com.github.juamougan.springstuff.validation.CuilConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cuil {
    @CuilConstraint
    private String cuil;
}
