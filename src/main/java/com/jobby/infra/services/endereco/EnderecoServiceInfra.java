package com.jobby.infra.services.endereco;

import com.jobby.core.exceptions.EnderecoInvalidoException;
import com.jobby.core.models.dtos.endereco.EnderecoDto;
import com.jobby.core.repositories.endereco.EnderecoHTTPRepository;
import org.springframework.stereotype.Service;

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
