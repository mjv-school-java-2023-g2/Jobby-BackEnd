package com.jobby.core.models.dtos.endereco;

import com.jobby.core.models.entities.endereco.Cidade;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Builder
@Data
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
