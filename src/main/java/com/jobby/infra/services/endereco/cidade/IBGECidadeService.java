package com.jobby.infra.services.endereco.cidade;

import com.fasterxml.jackson.databind.JsonNode;
import com.jobby.core.models.dtos.CidadeDto;
import com.jobby.core.repositories.http.CidadeHTTPRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IBGECidadeService implements CidadeHTTPRepository {
    @Override
    public CidadeDto findCidade(Integer ibge) {
        RestTemplate restTemplate = new RestTemplate();
        JsonNode json = restTemplate
                .getForObject(
                        "https://servicodados.ibge.gov.br/api/v1/localidades/municipios/"
                                + ibge,
                        JsonNode.class
                );
        JsonNode uf = json.path("regiao-imediata").path("regiao-intermediaria").path("UF");

        return CidadeDto.builder()
                .id(ibge)
                .nome(json.path("nome").asText())
                .sigla(uf.path("sigla").asText())
                .estado(uf.path("nome").asText())
                .build();
    }
}
