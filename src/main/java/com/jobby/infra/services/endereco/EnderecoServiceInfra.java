package com.jobby.infra.services.endereco;

import com.jobby.core.exceptions.EnderecoInvalidoException;
import com.jobby.core.models.requests.EnderecoRequest;
import com.jobby.core.repositories.http.EnderecoHTTPRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class EnderecoServiceInfra implements EnderecoHTTPRepository {
    public EnderecoRequest findEndereco(EnderecoRequest enderecoRequest) {
        String numero = enderecoRequest.getNumero();
        String complemento = enderecoRequest.getComplemento();
        enderecoRequest = restEndereco(enderecoRequest);
        if (enderecoRequest.getLogradouro() == null){
            throw new EnderecoInvalidoException("Cep inválido");
        }

        enderecoRequest.setNumero(numero);
        enderecoRequest.setComplemento(complemento);

        return enderecoRequest;
    }

    abstract EnderecoRequest restEndereco(EnderecoRequest enderecoRequest);
}
