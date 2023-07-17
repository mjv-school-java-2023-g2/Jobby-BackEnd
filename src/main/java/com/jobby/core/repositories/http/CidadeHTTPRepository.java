package com.jobby.core.repositories.http;

import com.jobby.core.models.requests.CidadeRequest;

public interface CidadeHTTPRepository {

    CidadeRequest findCidade(Integer ibge);
}
