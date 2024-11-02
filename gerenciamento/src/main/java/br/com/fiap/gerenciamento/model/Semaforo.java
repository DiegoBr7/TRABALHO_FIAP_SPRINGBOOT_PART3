package br.com.fiap.gerenciamento.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TB_SEMAFORO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Semaforo {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEMAFORO_SEQ"
    )
    @SequenceGenerator(
            name = "SEMAFORO_SEQ" ,
            sequenceName = "SEMAFORO_SEQ" ,
            allocationSize = 1
    )

    private Long id;
    private String localizacao;
    private String status;
    private int fluxoTrafego;

}
