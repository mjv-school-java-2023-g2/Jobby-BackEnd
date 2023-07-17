package com.jobby.core.models.entities.candidato.experiencia;

import com.jobby.core.models.enuns.Regime;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "experiencia")
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NotNull
    @Column(name = "candidato_id")
    private Integer candidatoId;
    @ManyToOne(cascade = CascadeType.ALL)
    private Profissao profissao;
    @NotNull
    @Column(name = "salario")
    private BigDecimal salario;
    @Column(name = "emprego_atual")
    private boolean empregoAtual;
    @Column(name = "regime")
    @Enumerated(EnumType.STRING)
    private Regime regime;
    @NotBlank
    @Column(name = "empresa")
    private String empresa;

}
