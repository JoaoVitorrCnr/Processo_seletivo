package com.example.PROCESSO_SELETIVO_LOGAP_2024.controller;

import com.example.PROCESSO_SELETIVO_LOGAP_2024.model.Fornecedor;
import com.example.PROCESSO_SELETIVO_LOGAP_2024.model.Produto;
import com.example.PROCESSO_SELETIVO_LOGAP_2024.service.ListagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/listagem")
public class ListagemCOntroller {

    @Autowired
    private ListagemService listagemService;

    
    @GetMapping("/categorias-produtos")
    public List<Object[]> listarCategoriasComQuantidadeDeProdutosEmEstoque() {
        return listagemService.listarCategoriasComQuantidadeDeProdutosEmEstoque();
    }

   
    @GetMapping("/produtos-faltando")
    public List<Produto> listarProdutosFaltandoEmEstoque() {
        return listagemService.listarProdutosFaltandoEmEstoque();
    }

    @GetMapping("/fornecedores-faltando")
    public ResponseEntity<?> listarFornecedoresComProdutosFaltandoEmEstoque() {
        try {
            List<Fornecedor> fornecedores = listagemService.listarFornecedoresComProdutosFaltandoEmEstoque();
            return new ResponseEntity<>(fornecedores, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao carregar dados: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
