package com.jobby.core.models.responses;

import com.jobby.core.models.entities.endereco.Cidade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CidadeResponse {
    private String nome;
    private String estado;

    public CidadeResponse(Cidade cidade) {
        BeanUtils.copyProperties(cidade, this);
    }
}
