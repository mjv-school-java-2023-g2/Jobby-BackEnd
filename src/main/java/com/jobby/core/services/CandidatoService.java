package com.jobby.core.services;

import com.jobby.core.models.dtos.CandidatoDto;
import com.jobby.core.models.dtos.EnderecoDto;
import com.jobby.core.models.entities.candidato.Candidato;
import com.jobby.core.models.entities.endereco.Endereco;
import com.jobby.core.repositories.persistence.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatoService {
    @Autowired
    EnderecoService enderecoService;
    @Autowired
    CandidatoRepository candidatoRepository;

    public Candidato saveCandidato(CandidatoDto candidatoDto){
        Candidato candidato = enderecoFactory(candidatoDto);

        candidatoRepository.save(candidato);

        return candidato;
    }

    private Candidato enderecoFactory(CandidatoDto candidatoDto){
        Endereco endereco = enderecoService
                .findEndereco(candidatoDto.getEndereco());

        Candidato candidato = candidatoDto.toCandidato();

        candidato.setEndereco(endereco);

        return candidato;
    }
}
