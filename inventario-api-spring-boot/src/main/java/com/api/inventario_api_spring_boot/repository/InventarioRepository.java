package com.api.inventario_api_spring_boot.repository;

import com.api.inventario_api_spring_boot.models.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepository extends JpaRepository<Inventario, Integer> {
}
