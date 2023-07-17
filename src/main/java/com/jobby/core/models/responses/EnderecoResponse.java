package com.jobby.core.models.responses;

import com.jobby.core.models.entities.candidato.Candidato;
import com.jobby.core.models.entities.endereco.Cidade;
import com.jobby.core.models.entities.endereco.Endereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnderecoResponse {
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private CidadeResponse cidade;

    public EnderecoResponse(Endereco endereco) {
        this.cidade = new CidadeResponse(endereco.getCidade());
        BeanUtils.copyProperties(endereco, this);
    }
}
