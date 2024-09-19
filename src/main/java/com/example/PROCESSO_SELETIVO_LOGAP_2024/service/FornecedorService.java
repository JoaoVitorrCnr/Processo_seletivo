package com.example.PROCESSO_SELETIVO_LOGAP_2024.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.PROCESSO_SELETIVO_LOGAP_2024.model.Fornecedor;
import com.example.PROCESSO_SELETIVO_LOGAP_2024.repository.FornecedorRepository;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<Fornecedor> listarTodos() {
        return fornecedorRepository.findAll();
    }

    public Fornecedor buscarPorId(Long id) {
        return fornecedorRepository.findById(id).orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
    }
}