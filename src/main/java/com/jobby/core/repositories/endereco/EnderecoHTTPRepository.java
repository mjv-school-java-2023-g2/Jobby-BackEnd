package com.jobby.core.repositories.endereco;

import com.jobby.core.models.dtos.endereco.EnderecoDto;


public interface EnderecoHTTPRepository {

    EnderecoDto findEndereco(EnderecoDto EnderecoDto);

}
