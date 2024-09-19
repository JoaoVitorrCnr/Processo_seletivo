package com.example.PROCESSO_SELETIVO_LOGAP_2024.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.PROCESSO_SELETIVO_LOGAP_2024.model.Categoria;
import com.example.PROCESSO_SELETIVO_LOGAP_2024.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listarTodas() {
        return categoriaRepository.findAll();
    }
    
    public Categoria buscarPorId(Long id) {
        return categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }
}
