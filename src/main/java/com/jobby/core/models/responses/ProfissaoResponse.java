package com.jobby.core.models.responses;

import com.jobby.core.models.entities.candidato.experiencia.Profissao;
import com.jobby.core.models.entities.endereco.Endereco;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class ProfissaoResponse {
    private String nome;

    public ProfissaoResponse(Profissao profissao) {
        BeanUtils.copyProperties(profissao, this);
    }
}
