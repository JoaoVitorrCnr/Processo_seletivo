package com.example.PROCESSO_SELETIVO_LOGAP_2024.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.PROCESSO_SELETIVO_LOGAP_2024.Dto.ProdutoDTO;
import com.example.PROCESSO_SELETIVO_LOGAP_2024.model.Categoria;
import com.example.PROCESSO_SELETIVO_LOGAP_2024.model.Fornecedor;
import com.example.PROCESSO_SELETIVO_LOGAP_2024.model.Produto;
import com.example.PROCESSO_SELETIVO_LOGAP_2024.service.CategoriaService;
import com.example.PROCESSO_SELETIVO_LOGAP_2024.service.FornecedorService;
import com.example.PROCESSO_SELETIVO_LOGAP_2024.service.ProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping("/listar")
    public String listarProdutos(Model model) {
        List<ProdutoDTO> produtos = produtoService.listarTodos();
        model.addAttribute("produtos", produtos);
        return "gerenciarProdutos.html";
    }

    @GetMapping("/novo")
    public String mostrarFormularioDeCriacao(Model model) {
        model.addAttribute("categorias", categoriaService.listarTodas());
        model.addAttribute("fornecedores", fornecedorService.listarTodos());
        model.addAttribute("produto", new Produto()); 
        return "AdicionarVenda";
    }

    @PostMapping
    public String criarProduto(@RequestParam("nome") String nome,
                                @RequestParam("valorCompra") Double valorCompra,
                                @RequestParam("estoque") Integer estoque,
                                @RequestParam("categoria.id") Long categoriaId,
                                @RequestParam("fornecedor.id") Long fornecedorId) {

        Categoria categoria = categoriaService.buscarPorId(categoriaId);
        Fornecedor fornecedor = fornecedorService.buscarPorId(fornecedorId);

        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setValorCompra(valorCompra);
        produto.setEstoque(estoque); 
        produto.setCategoria(categoria);
        produto.setFornecedorProduto(fornecedor);

        produtoService.criarProduto(produto);
        return "redirect:/produtos/listar";
    }

    @GetMapping("/update/{id}")
    public String mostrarFormularioDeEdicao(@PathVariable Long id, Model model) {
        Optional<Produto> produtoOpt = produtoService.buscarPorId(id);

        if (produtoOpt.isPresent()) {
            Produto produto = produtoOpt.get();
            model.addAttribute("produto", produto);
            model.addAttribute("categorias", categoriaService.listarTodas());
            model.addAttribute("fornecedores", fornecedorService.listarTodos());
            return "atualizarProduto";
        } else {
            return "atualizarProduto";
        }
    }

    @PostMapping("/update/{id}")
    public String atualizarProduto(@PathVariable Long id,
                                   @RequestParam("nome") String nome,
                                   @RequestParam("valorCompra") Double valorCompra,
                                   @RequestParam("estoque") Integer estoque,
                                   @RequestParam("categoria.id") Long categoriaId,
                                   @RequestParam("fornecedor.id") Long fornecedorId) {

        Produto produto = produtoService.buscarPorId(id)
            .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        Categoria categoria = categoriaService.buscarPorId(categoriaId);
        Fornecedor fornecedor = fornecedorService.buscarPorId(fornecedorId);
        produto.setNome(nome);
        produto.setValorCompra(valorCompra);
        produto.setEstoque(estoque);
        produto.setCategoria(categoria);
        produto.setFornecedorProduto(fornecedor);
        produtoService.atualizarProduto(produto);
        return "redirect:/produtos/listar";
    }

    @PostMapping("/delete/{id}")
    public String deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
        return "redirect:/produtos/listar";
    }
}
