package com.api.inventario_api_spring_boot.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "inventario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer id; 
    private Integer cantidad;
}