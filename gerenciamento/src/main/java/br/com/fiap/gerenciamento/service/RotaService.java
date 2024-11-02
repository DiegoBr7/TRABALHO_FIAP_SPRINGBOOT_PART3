package br.com.fiap.gerenciamento.service;

import br.com.fiap.gerenciamento.model.Rota;
import br.com.fiap.gerenciamento.repository.RotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RotaService {

    @Autowired
    private RotaRepository rotaRepository;

    public Rota salvarRota(Rota rota){
        return rotaRepository.save(rota);
    }

    public List<Rota> buscarTodasRotas(){
        return rotaRepository.findAll();
    }

    public Optional<Rota> buscarRotaPorId(Long id){
        return rotaRepository.findById(id);
    }

    public Rota atualizarRota(Long id , Rota rotaAtualizada){
        return rotaRepository.findById(id).map(rota -> {
            rota.setOrigem(rotaAtualizada.getOrigem());
            rota.setDestino(rotaAtualizada.getDestino());
            rota.setDuracao(rotaAtualizada.getDuracao());
            rota.setCongestionada(rotaAtualizada.isCongestionada());
            return rotaRepository.save(rota);
        })
        .orElseThrow(() -> new RuntimeException("Rota não encontrada"));
    }
    public void deletarRota(Long id){
        rotaRepository.deleteById(id);
    }


}
