package com.jobby.core.models.entities.candidato;

import com.jobby.core.models.enuns.TipoTelefone;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "Telefone é obrigatório")
    @Size(min = 10, max = 10, message = "O telefone deve conter exatamente caracteres numéricos incluindo o DDD")
    @Column(name = "telefone_numero")
    private Long numero;
    @NotBlank
    @Column(name = "telefone_is_whatsapp")
    private boolean whatsapp;
    @Enumerated(EnumType.STRING)
    @NotBlank
    @Column(name = "telefone_tipo")
    private TipoTelefone tipo;
}
