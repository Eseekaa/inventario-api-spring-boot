package com.api.inventario_api_spring_boot.services;

import com.api.inventario_api_spring_boot.models.Inventario;
import com.api.inventario_api_spring_boot.repository.InventarioRepository;
import com.api.inventario_api_spring_boot.dto.InventarioDTO;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class inventarioservices {

    @Autowired
    private InventarioRepository inventarioRepository;

    private Inventario toEntity(InventarioDTO inventarioDTO) {
        Inventario inventario = new Inventario();
        inventario.setId(inventarioDTO.getId());
        inventario.setCantidad(inventarioDTO.getCantidad());
        return inventario;
    }

    private InventarioDTO toDTO(Inventario inventario) {
        InventarioDTO inventarioDTO = new InventarioDTO();
        inventarioDTO.setId(inventario.getId());
        inventarioDTO.setCantidad(inventario.getCantidad());
        return inventarioDTO;
    }

    public InventarioDTO guardarInventario(InventarioDTO inventarioDTO) {
        Inventario inventario = toEntity(inventarioDTO);
        inventario = inventarioRepository.save(inventario);
        return toDTO(inventario);
    }

    public List<InventarioDTO> obtenerInventarios() {
        List<Inventario> inventarios = inventarioRepository.findAll();
        return inventarios.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public InventarioDTO obtenerInventarioPorId(Integer id) {
        Inventario inventario = inventarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Inventario no encontrado con id: " + id));
        return toDTO(inventario);
    }

    public InventarioDTO actualizarInventario(InventarioDTO inventarioDTO) {
        inventarioRepository.findById(inventarioDTO.getId())
            .orElseThrow(() -> new RuntimeException("Inventario no encontrado con id: " + inventarioDTO.getId()));
        Inventario inventario = toEntity(inventarioDTO);
        inventario = inventarioRepository.save(inventario);
        return toDTO(inventario);
    }

    public void eliminarInventario(Integer id) {
        inventarioRepository.deleteById(id);
    }
}