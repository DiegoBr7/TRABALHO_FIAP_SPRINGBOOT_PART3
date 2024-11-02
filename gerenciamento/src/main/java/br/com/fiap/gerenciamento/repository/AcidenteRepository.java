package br.com.fiap.gerenciamento.repository;

import br.com.fiap.gerenciamento.model.Acidente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcidenteRepository extends JpaRepository <Acidente, Long> {
}
