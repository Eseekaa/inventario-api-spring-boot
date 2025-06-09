package com.api.inventario_api_spring_boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

import com.api.inventario_api_spring_boot.dto.InventarioDTO;
import com.api.inventario_api_spring_boot.services.inventarioservices;

@RestController
@RequestMapping("/api/inventario")
public class InventarioController {

    @Autowired
    private inventarioservices inventarioServices;

    @GetMapping
    public List<InventarioDTO> obtenerInventarios() {
        return inventarioServices.obtenerInventarios();
    }

    @GetMapping("/{id}")
    public InventarioDTO obtenerInventarioPorId(@PathVariable Integer id) {
        return inventarioServices.obtenerInventarioPorId(id);
    }

    @PostMapping
    public InventarioDTO guardarInventario(@RequestBody InventarioDTO inventarioDTO) {
        return inventarioServices.guardarInventario(inventarioDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventarioDTO> actualizarInventario(@PathVariable Integer id, @RequestBody InventarioDTO inventarioDTO) {
        inventarioDTO.setId(id); 
        InventarioDTO actualizado = inventarioServices.actualizarInventario(inventarioDTO);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarInventario(@PathVariable Integer id) {
        inventarioServices.eliminarInventario(id);
        return ResponseEntity.noContent().build();
    }
}