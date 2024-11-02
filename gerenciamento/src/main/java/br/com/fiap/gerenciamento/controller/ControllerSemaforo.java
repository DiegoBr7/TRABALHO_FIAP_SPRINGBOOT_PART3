package br.com.fiap.gerenciamento.controller;

import br.com.fiap.gerenciamento.model.Rota;
import br.com.fiap.gerenciamento.model.Semaforo;
import br.com.fiap.gerenciamento.service.SemaforoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ControllerSemaforo {

    private SemaforoService semaforoService ;

    @PostMapping("/semaforo")
    @ResponseStatus(HttpStatus.CREATED)
    public Semaforo salvarS (@RequestBody Semaforo semaforo){
        return semaforoService.salvarSemaforo(semaforo);
    }

    @GetMapping("/semaforo")
    @ResponseStatus(HttpStatus.OK)
    public List<Semaforo> buscarTodosS(){
        return semaforoService.buscarTodosSemaforos();
    }

    @GetMapping("/semaforo/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Semaforo> buscarSemaforoPeloId(@PathVariable Long id){
        return semaforoService.buscarSemaforoPotId(id);
    }

    @PutMapping("/semaforo/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Semaforo atualizarS (@PathVariable Long id , @RequestBody Semaforo semaforo){
        return semaforoService.atualizarSemaforo(id, semaforo);
    }

    @DeleteMapping("/semaforo/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarS(@PathVariable Long id){
        semaforoService.deletarSemaforo(id);
    }

}
