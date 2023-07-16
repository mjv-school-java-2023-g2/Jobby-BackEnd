package com.jobby.core.models.entities.candidato;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class PretencaoSalarial {
    @NotBlank
    @Column(name = "pretencao_salarial_minimo")
    private BigDecimal minimo;
    @NotBlank
    @Column(name = "pretencao_salarial_maximo")
    private BigDecimal maximo;
}
