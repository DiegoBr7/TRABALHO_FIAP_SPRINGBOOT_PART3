package br.com.fiap.gerenciamento.controller;


import br.com.fiap.gerenciamento.model.Acidente;
import br.com.fiap.gerenciamento.model.Rota;
import br.com.fiap.gerenciamento.service.AcidenteService;
import br.com.fiap.gerenciamento.service.RotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ControllerRota {

    @Autowired
    private RotaService rotaService;

    @PostMapping("/rota")
    @ResponseStatus(HttpStatus.CREATED)
    public Rota salvarR (@RequestBody Rota rota){
        return rotaService.salvarRota(rota);
    }

    @GetMapping("/rota")
    @ResponseStatus(HttpStatus.OK)
    public List<Rota> buscarTodosR(){
        return rotaService.buscarTodasRotas();
    }

    @GetMapping("/rota/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Rota> buscarRotaPeloId(@PathVariable Long id){
        return  rotaService.buscarRotaPorId(id);
    }

    @PutMapping("/rota/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Rota atualizarR (@PathVariable Long id , @RequestBody Rota rota){
        return   rotaService.atualizarRota(id , rota);
    }

    @DeleteMapping("/contatos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarR(@PathVariable Long id){
        rotaService.deletarRota(id);
    }



}
