package com.example.PROCESSO_SELETIVO_LOGAP_2024.repository;

import com.example.PROCESSO_SELETIVO_LOGAP_2024.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT p FROM Produto p WHERE p.estoque <= 0")
    List<Produto> findProdutosFaltandoEmEstoque();
}
