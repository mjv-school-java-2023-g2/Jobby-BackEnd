package com.jobby.core.models.entities.candidato;


import com.jobby.core.models.entities.telefone.Telefone;

import jakarta.persistence.*;
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
@Table(name = "tb_candidato")
@Entity
public class Candidato {

    @NotEmpty(message = "Telefone é obrigatório")
    @Size(min = 10, max = 10, message = "O telefone deve conter exatamente caracteres numéricos incluindo o DDD")
    private Long telefone;

    @Embedded
    private Telefone profissional;

    @Embedded
    private Telefone pessoal;

}
