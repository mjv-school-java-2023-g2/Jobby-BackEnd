package com.jobby.core.repositories.http;

import com.jobby.core.models.requests.EnderecoRequest;


public interface EnderecoHTTPRepository {

    EnderecoRequest findEndereco(EnderecoRequest EnderecoRequest);

}
