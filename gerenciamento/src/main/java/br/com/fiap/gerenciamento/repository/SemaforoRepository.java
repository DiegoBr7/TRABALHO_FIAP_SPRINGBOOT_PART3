package br.com.fiap.gerenciamento.repository;

import br.com.fiap.gerenciamento.model.Semaforo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemaforoRepository extends JpaRepository <Semaforo, Long> {
}
