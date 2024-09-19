package com.example.PROCESSO_SELETIVO_LOGAP_2024.controller;

import java.util.HashSet;
import java.util.Set;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.PROCESSO_SELETIVO_LOGAP_2024.model.StringModel;

@RestController
@RequestMapping("/string")
public class StringController {
    
    @PostMapping("/processar")
    public ResponseEntity<StringModel> processarString(@RequestBody StringModel stringModel) {
        String inputString = stringModel.getString().toLowerCase();
        char candidata = '\0'; 
        Set<Character> vogaisEncontradas = new HashSet<>(); 
        String vogais = "aeiou";
        boolean encontrouCDDT = false;

        for (int i = 2; i < inputString.length(); i++) {
            char atual = inputString.charAt(i);
            char meio = inputString.charAt(i - 1);
            char anterior = inputString.charAt(i - 2);

            if(encontrouCDDT == false){
                if (vogais.indexOf(atual) != -1 && !vogaisEncontradas.contains(atual) && 
                    !vogais.contains(String.valueOf(meio)) && vogais.indexOf(anterior) != -1) {
                    candidata = atual;
                    vogaisEncontradas.add(atual);
                    encontrouCDDT = true;
                    i++;
                }
            }else{
                vogaisEncontradas.add(inputString.charAt(i));
                if(inputString.charAt(i) == candidata){
                    encontrouCDDT = false;
                }else{
                    encontrouCDDT = true;
                }
            }
           
        }

        stringModel.setVogal(candidata);
        return ResponseEntity.ok(stringModel);
    }
}