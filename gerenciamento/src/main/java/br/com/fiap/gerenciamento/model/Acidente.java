package br.com.fiap.gerenciamento.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_ACIDENTE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Acidente {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ACIDENTE_SEQ"
    )
    @SequenceGenerator(
            name = "ACIDENTE_SEQ",
            sequenceName = "ACIDENTE_SEQ",
            allocationSize = 1
    )
    private Long id;

    private String localizacao;
    private String gravidade;
    private LocalDateTime data;


}