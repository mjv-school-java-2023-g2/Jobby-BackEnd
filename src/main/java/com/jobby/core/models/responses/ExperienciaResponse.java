package com.jobby.core.models.responses;

import com.jobby.core.models.entities.candidato.experiencia.Experiencia;
import com.jobby.core.models.entities.candidato.experiencia.Profissao;
import com.jobby.core.models.enuns.Regime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExperienciaResponse {
    private Integer candidatoId;
    private Profissao profissao;
    private BigDecimal salario;
    private boolean empregoAtual;
    private Regime regime;
    private String empresa;
    public ExperienciaResponse(Experiencia experiencia) {
        BeanUtils.copyProperties(experiencia, this);
    }
}
