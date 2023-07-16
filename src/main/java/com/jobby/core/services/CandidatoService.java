package com.jobby.core.services;

import com.jobby.core.exceptions.CandidatoNotFoundException;
import com.jobby.core.models.dtos.CandidatoDto;
import com.jobby.core.models.entities.candidato.Candidato;
import com.jobby.core.models.entities.endereco.Endereco;
import com.jobby.core.repositories.persistence.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidatoService {
    @Autowired
    EnderecoService enderecoService;
    @Autowired
    CandidatoRepository candidatoRepository;

    public CandidatoDto saveCandidato(CandidatoDto candidatoDto){
        Candidato candidato = enderecoFactory(candidatoDto);

        candidatoRepository.save(candidato);

        return new CandidatoDto(candidato);
    }

    public CandidatoDto update(String cpf, CandidatoDto request) {
       return candidatoRepository.findByCpf(cpf).map( candidato -> {
            candidato = enderecoFactory(request);
            candidatoRepository.save(candidato);
            return new CandidatoDto(candidato);
        }).orElseThrow(() -> new CandidatoNotFoundException("cpf not found"));
    }

    public List<CandidatoDto> getAll(){
       return candidatoRepository.findAll().stream()
               .map(CandidatoDto::new)
               .collect(Collectors.toList());
    }

    private Candidato enderecoFactory(CandidatoDto candidatoDto){
        Endereco endereco = enderecoService
                .findEndereco(candidatoDto.getEndereco());
        Candidato candidato = candidatoDto.toCandidato();

        candidato.setEndereco(endereco);

        return candidato;
    }

    public boolean delete(String cpf) {
         return candidatoRepository.findByCpf(cpf).map(candidato -> {
            candidato.setStatus(false);
            return true;
         }).orElse(false);
    }
}
