package com.jobby.core.models.entities.pretencao_salarial;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class PretencaoSalarial {
    private Double minimo;
    private Double maximo;
}
