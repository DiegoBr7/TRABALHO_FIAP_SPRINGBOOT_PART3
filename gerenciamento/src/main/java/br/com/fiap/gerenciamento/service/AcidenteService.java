package br.com.fiap.gerenciamento.service;

import br.com.fiap.gerenciamento.model.Acidente;
import br.com.fiap.gerenciamento.repository.AcidenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcidenteService {

    @Autowired
    private AcidenteRepository acidenteRepository;

    public Acidente salvarAcidente(Acidente acidente){
        return acidenteRepository.save(acidente);
    }

    public List<Acidente> buscarTodosAcidentes(){
        return acidenteRepository.findAll();
    }

    public Optional<Acidente> buscarAcidentePorId(Long id) {
        return acidenteRepository.findById(id);
    }

    public void deletarAcidente(Long id) {
        acidenteRepository.deleteById(id);
    }

}
