package com.jobby.core.repository.endereco;

import com.jobby.core.models.dtos.EnderecoDto;


public interface EnderecoHTTPRepository {

    EnderecoDto findEndereco(EnderecoDto EnderecoDto);

}
