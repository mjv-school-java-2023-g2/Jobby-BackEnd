package com.jobby.core.repositories.http;

import com.jobby.core.models.dtos.endereco.EnderecoDto;


public interface EnderecoHTTPRepository {

    EnderecoDto findEndereco(EnderecoDto EnderecoDto);

}