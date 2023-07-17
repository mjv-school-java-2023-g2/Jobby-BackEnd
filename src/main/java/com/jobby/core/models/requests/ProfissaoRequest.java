package com.jobby.core.models.requests;

import com.jobby.core.models.entities.candidato.experiencia.Experiencia;
import com.jobby.core.models.entities.candidato.experiencia.Profissao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProfissaoRequest {
    private Integer id;
    private String nome;

    public Profissao toProfissao(){
        Profissao profissao = new Profissao();
        BeanUtils.copyProperties(this, profissao);
        return profissao;
    }
}
