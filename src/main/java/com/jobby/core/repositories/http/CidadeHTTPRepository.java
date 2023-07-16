package com.jobby.core.repositories.http;

import com.jobby.core.models.dtos.CidadeDto;

public interface CidadeHTTPRepository {

    CidadeDto findCidade(Integer ibge);
}
