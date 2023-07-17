package com.jobby.core.models.dtos;

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
public class ExperienciaDto {
    private Integer id;
    private Integer candidatoId;
    private Profissao profissao;
    private BigDecimal salario;
    private boolean empregoAtual;
    private Regime regime;
    private String empresa;

    public ExperienciaDto(Experiencia experiencia) {
        BeanUtils.copyProperties(experiencia, this);
    }

    public Experiencia toExperiencia(){
        Experiencia experiencia = new Experiencia();
        BeanUtils.copyProperties(this, experiencia);
        return experiencia;
    }
}
