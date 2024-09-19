package com.example.PROCESSO_SELETIVO_LOGAP_2024.repository;

import com.example.PROCESSO_SELETIVO_LOGAP_2024.model.Fornecedor;
import com.example.PROCESSO_SELETIVO_LOGAP_2024.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListagemRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT c.nome, SUM(p.estoque) " +
           "FROM Categoria c JOIN c.produtos p " +
           "GROUP BY c.nome")
    List<Object[]> findCategoriasComQuantidadeDeProdutosEmEstoque();

    @Query("SELECT p FROM Produto p WHERE p.estoque <= 0")
    List<Produto> findProdutosFaltandoEmEstoque();

    @Query("SELECT DISTINCT f FROM Fornecedor f JOIN f.produtos p WHERE p.estoque <= 0")
    List<Fornecedor> findFornecedoresComProdutosFaltandoEmEstoque();
}
