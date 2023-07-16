package com.jobby.core.services;

import com.jobby.core.models.dtos.endereco.EnderecoDto;
import com.jobby.core.models.entities.candidato.Candidato;
import com.jobby.core.models.entities.endereco.Endereco;
import com.jobby.core.repositories.persistence.CandidatoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatoService {
    @Autowired
    EnderecoService enderecoService;
    @Autowired
    CandidatoRepository candidatoRepository;

    public Candidato saveCandidato(Candidato candidato){
        candidato = enderecoFactory(candidato);

        candidatoRepository.save(candidato);

        return candidato;
    }

    private Candidato enderecoFactory(Candidato candidato){
        Endereco endereco = enderecoService
                .findEndereco(new EnderecoDto(candidato.getEndereco()));

        candidato.setEndereco(endereco);

        return candidato;
    }
}
