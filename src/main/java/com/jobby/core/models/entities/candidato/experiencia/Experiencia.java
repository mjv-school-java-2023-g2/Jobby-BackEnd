package com.jobby.core.models.entities.candidato.experiencia;

import com.jobby.core.models.enuns.Regime;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @NotBlank
    @Column(name = "candidato_id")
    private Integer candidatoId;
    @NotBlank
    @ManyToOne(cascade = CascadeType.ALL)
    private Profissao profissao;
    @NotBlank
    @Column(name = "salario")
    private BigDecimal salario;
    @NotBlank
    @Column(name = "emprego_atual")
    private boolean empregoAtual;
    @NotBlank
    @Column(name = "regime_trabalho")
    private Regime regime;
    @NotBlank
    @Column(name = "empresa")
    private String empresa;

}
