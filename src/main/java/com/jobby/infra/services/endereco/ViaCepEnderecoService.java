package com.jobby.infra.services.endereco;

import com.jobby.core.models.requests.EnderecoRequest;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Primary
public class ViaCepEnderecoService extends EnderecoServiceInfra {
    @Override
    public EnderecoRequest restEndereco(EnderecoRequest enderecoRequest) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate
                .getForObject(
                        "http://viacep.com.br/ws/" + enderecoRequest.getCep() + "/json/",
                        EnderecoRequest.class
                );
    }
}
