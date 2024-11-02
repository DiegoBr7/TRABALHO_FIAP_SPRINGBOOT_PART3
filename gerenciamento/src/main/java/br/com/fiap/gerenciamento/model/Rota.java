package br.com.fiap.gerenciamento.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TB_ROTA")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Rota {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ROTA_SEQ"
    )
    @SequenceGenerator(
            name = "ROTA_SEQ",
            sequenceName = "ROTA_SEQ",
            allocationSize = 1
    )

    private Long id;

    private String origem;
    private String destino;
    private int duracao;
    private boolean congestionada;

}
