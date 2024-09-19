package com.example.PROCESSO_SELETIVO_LOGAP_2024.service;

import com.example.PROCESSO_SELETIVO_LOGAP_2024.model.Fornecedor;
import com.example.PROCESSO_SELETIVO_LOGAP_2024.model.Produto;
import com.example.PROCESSO_SELETIVO_LOGAP_2024.repository.ListagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListagemService {

    @Autowired
    private ListagemRepository listagemRepository;

    public List<Object[]> listarCategoriasComQuantidadeDeProdutosEmEstoque() {
      return listagemRepository.findCategoriasComQuantidadeDeProdutosEmEstoque();
    }

    public List<Produto> listarProdutosFaltandoEmEstoque() {
      return listagemRepository.findProdutosFaltandoEmEstoque();
  }

    public List<Fornecedor> listarFornecedoresComProdutosFaltandoEmEstoque() {
      return listagemRepository.findFornecedoresComProdutosFaltandoEmEstoque();
  }
}
