package com.github.juamougan.springstuff.entities;

import com.github.juamougan.springstuff.validation.CuilConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cuil {
    @CuilConstraint             // Here I'm validating at an attribute level - only for this field
    private String cuil;
}
