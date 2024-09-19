package com.example.PROCESSO_SELETIVO_LOGAP_2024.Dto;

import lombok.Data;

@Data
public class ProdutoDTO {

    private Long id;
    private String nome;
    private Double valorCompra;
    private Integer estoque;
    private String categoriaNome;
    private String fornecedorNome;

    public ProdutoDTO(Long id, String nome, Double valorCompra, Integer estoque, String categoriaNome, String fornecedorNome) {
        this.id = id;
        this.nome = nome;
        this.valorCompra = valorCompra;
        this.estoque = estoque; 
        this.categoriaNome = categoriaNome;
        this.fornecedorNome = fornecedorNome;
    }
}
