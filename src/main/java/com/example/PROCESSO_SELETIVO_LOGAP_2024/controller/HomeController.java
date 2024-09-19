package com.example.PROCESSO_SELETIVO_LOGAP_2024.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "redirect:/menu";
    }
    
    @GetMapping("/menu")
    public String menu() {
        return "Menu";
    }

    @GetMapping("/gerenciarProdutos")
    public String gerenciarProdutos(){
        return "/gerenciarProdutos";
    }

    @GetMapping("/voltar")
    public String voltarHome(){
        return "/menu";
    }
}
