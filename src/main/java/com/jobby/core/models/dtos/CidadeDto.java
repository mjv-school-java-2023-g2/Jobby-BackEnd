package com.jobby.core.models.dtos;

import com.jobby.core.models.entities.endereco.Cidade;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import org.springframework.beans.BeanUtils;

@Builder
@Getter
public class CidadeDto {
    private Integer id;
    private String nome;
    private String estado;
    private String sigla;

    public Cidade toCidade(){
        Cidade cidade = new Cidade();
        BeanUtils.copyProperties(this, cidade);
        return cidade;
    }
}
