package com.jobby.core.services;

import com.jobby.core.models.dtos.endereco.EnderecoDto;
import com.jobby.core.models.entities.endereco.Cidade;
import com.jobby.core.models.entities.endereco.Endereco;
import com.jobby.core.repositories.http.CidadeHTTPRepository;
import com.jobby.core.repositories.persistence.CidadeRepository;
import com.jobby.core.repositories.http.EnderecoHTTPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    EnderecoHTTPRepository enderecoHTTPRepository;
    @Autowired
    CidadeHTTPRepository cidadeHTTPRepository;
    @Autowired
    CidadeRepository cidadeRepository;

    public Endereco findEndereco(EnderecoDto enderecoDto){

       enderecoDto = enderecoHTTPRepository
               .findEndereco(enderecoDto);

       Cidade cidade = findCidade(enderecoDto.getIbge());

       Endereco endereco = enderecoDto.toEndereco();
       endereco.setCidade(cidade);
       return endereco;
    }

    private Cidade findCidade(Integer ibge){
         return cidadeRepository.findById(ibge)
                .orElse(cidadeHTTPRepository.findCidade(ibge).toCidade());
    }

}
