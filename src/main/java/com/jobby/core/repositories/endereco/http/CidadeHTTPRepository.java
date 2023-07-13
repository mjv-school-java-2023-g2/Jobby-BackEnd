package com.jobby.core.repositories.endereco.http;

import com.jobby.core.models.dtos.endereco.CidadeDto;

public interface CidadeHTTPRepository {

    CidadeDto findCidade(Integer ibge);
}
