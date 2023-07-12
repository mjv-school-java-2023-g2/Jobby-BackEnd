package com.jobby.core.repository.endereco;

import com.jobby.core.models.dtos.CidadeDto;
import com.jobby.core.models.dtos.EnderecoDto;

public interface CidadeHTTPRepository {

    CidadeDto findCidade(Integer ibge);
}
