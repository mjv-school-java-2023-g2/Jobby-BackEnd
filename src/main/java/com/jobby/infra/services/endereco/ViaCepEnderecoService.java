package com.jobby.infra.services.endereco;

import com.jobby.core.models.dtos.EnderecoDto;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Primary
public class ViaCepEnderecoService extends EnderecoServiceInfra {
    @Override
    public EnderecoDto restEndereco(EnderecoDto enderecoDto) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate
                .getForObject(
                        "http://viacep.com.br/ws/" + enderecoDto.getCep() + "/json/",
                        EnderecoDto.class
                );
    }
}
