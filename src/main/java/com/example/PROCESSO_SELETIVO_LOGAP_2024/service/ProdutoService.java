package com.example.PROCESSO_SELETIVO_LOGAP_2024.service;

import com.example.PROCESSO_SELETIVO_LOGAP_2024.Dto.ProdutoDTO;
import com.example.PROCESSO_SELETIVO_LOGAP_2024.model.Produto;
import com.example.PROCESSO_SELETIVO_LOGAP_2024.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoDTO> listarTodos() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream().map(produto -> 
            new ProdutoDTO(
                produto.getId(),
                produto.getNome(),
                produto.getValorCompra(),
                produto.getEstoque(), 
                produto.getCategoria().getNome(),
                produto.getFornecedorProduto().getNome()
            )
        ).collect(Collectors.toList());
    }

    public Produto criarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto atualizarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }

    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public List<Produto> listarProdutosFaltandoEmEstoque() {
        return produtoRepository.findProdutosFaltandoEmEstoque();
    }
}
