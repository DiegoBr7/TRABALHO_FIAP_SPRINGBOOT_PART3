package br.com.fiap.gerenciamento.controller;

import br.com.fiap.gerenciamento.model.Acidente;
import br.com.fiap.gerenciamento.service.AcidenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ControllerAcidente {
    @Autowired
    private AcidenteService acidenteService;

    @PostMapping("/acidente")
    @ResponseStatus(HttpStatus.CREATED)
    public Acidente salvarA (@RequestBody Acidente acidente){
        return acidenteService.salvarAcidente(acidente);
    }

    @GetMapping("/acidente")
    @ResponseStatus(HttpStatus.OK)
    public List<Acidente> buscarTodosA(){
        return acidenteService.buscarTodosAcidentes();
    }

    @GetMapping("/acidente/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Acidente> buscarAcidentePeloId(@PathVariable Long id){
        return  acidenteService.buscarAcidentePorId(id);
    }

    @DeleteMapping("/acidente/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarA(@PathVariable Long id){
         acidenteService.deletarAcidente(id);
    }

}
