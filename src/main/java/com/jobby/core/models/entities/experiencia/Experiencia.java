package com.jobby.core.models.entities.experiencia;

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
@Table(name = "tb_experiencia")
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
    private BigDecimal salario;
    @NotBlank
    @Column(name = "emprego_atual")
    private boolean empregoAtual;
    @NotBlank
    private Regime regime;
    @NotBlank
    private String empresa;

}
