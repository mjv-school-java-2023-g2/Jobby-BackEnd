package com.jobby.core.models.entities.candidato;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Telefone {
    @NotEmpty(message = "Telefone é obrigatório")
    @Size(min = 10, max = 10, message = "O telefone deve conter exatamente caracteres numéricos incluindo o DDD")
    private Long numero;
    private boolean isWhatsapp;
    private TipoTelefone tipo;
}
