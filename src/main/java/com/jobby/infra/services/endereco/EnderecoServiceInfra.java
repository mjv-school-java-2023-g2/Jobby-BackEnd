package com.jobby.infra.services.endereco;

import com.fasterxml.jackson.databind.JsonNode;
import com.jobby.core.exceptions.EnderecoInvalidoException;
import com.jobby.core.models.dtos.EnderecoDto;
import com.jobby.core.models.entities.endereco.Cidade;
import com.jobby.core.models.entities.endereco.Endereco;
import com.jobby.core.repository.endereco.EnderecoHTTPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public abstract class EnderecoServiceInfra implements EnderecoHTTPRepository {
    public EnderecoDto findEndereco(EnderecoDto enderecoDto) {
        String numero = enderecoDto.getNumero();
        String complemento = enderecoDto.getComplemento();
        enderecoDto = restEndereco(enderecoDto);
        if (enderecoDto.getLogradouro() == null){
            throw new EnderecoInvalidoException("Cep inválido");
        }

        enderecoDto.setNumero(numero);
        enderecoDto.setComplemento(complemento);

        return enderecoDto;
    }

    abstract EnderecoDto restEndereco(EnderecoDto enderecoDto);
}
