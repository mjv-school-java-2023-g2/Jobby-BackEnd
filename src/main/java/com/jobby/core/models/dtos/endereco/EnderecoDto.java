package com.jobby.core.models.dtos.endereco;

import com.jobby.core.models.entities.endereco.Endereco;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnderecoDto {
    private Integer id;
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private Integer ibge;
    private String localidade;
    private String uf;
    private String sigla;

    public Endereco toEndereco(){
        Endereco endereco = new Endereco();
        BeanUtils.copyProperties(this, endereco);
        return endereco;
    }
}
