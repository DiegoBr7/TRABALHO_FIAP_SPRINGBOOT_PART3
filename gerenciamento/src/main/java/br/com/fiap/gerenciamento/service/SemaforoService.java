package br.com.fiap.gerenciamento.service;

import br.com.fiap.gerenciamento.model.Semaforo;
import br.com.fiap.gerenciamento.repository.SemaforoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;
import br.com.fiap.gerenciamento.repository.AcidenteRepository;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@Service
public class SemaforoService {
    @Autowired
    private SemaforoRepository semaforoRepository;

    public Semaforo salvarSemaforo(Semaforo semaforo){
        return semaforoRepository.save(semaforo);
    }

    public List<Semaforo> buscarTodosSemaforos(){
        return semaforoRepository.findAll();
    }
    public Optional<Semaforo> buscarSemaforoPotId(Long id){
        return semaforoRepository.findById(id);
    }

    // Metodo para atualizar um semaforo existente
    public Semaforo atualizarSemaforo(Long id, Semaforo semaforoAtualizado){
        return semaforoRepository.findById(id).map(semaforo -> {
            semaforo.setLocalizacao(semaforoAtualizado.getLocalizacao());
            semaforo.setStatus(semaforoAtualizado.getStatus());
            semaforo.setFluxoTrafego(semaforoAtualizado.getFluxoTrafego());
            return semaforoRepository.save(semaforo);
        }).orElseThrow(() -> new RuntimeException("SEMAFORO NAO ENCONTRADO!"));

    }

    //Metodo para deletar um semaforo

    public void deletarSemaforo(Long id){
        semaforoRepository.deleteById(id);
    }

}
