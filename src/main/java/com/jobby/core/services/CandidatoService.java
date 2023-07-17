package com.jobby.core.services;

import com.jobby.core.exceptions.NotFoundException;
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

    public CandidatoDto save(CandidatoDto candidatoDto){

        if (candidatoRepository.
                findByCpf(candidatoDto.getCpf()).isPresent()) {
            throw new IllegalArgumentException();
        }

        Candidato candidato = enderecoFactory(candidatoDto);

        candidatoRepository.save(candidato);

        return new CandidatoDto(candidato);
    }

    public CandidatoDto update(String cpf, CandidatoDto request) {
       return candidatoRepository.findByCpf(cpf).map( candidato -> {
            candidato = enderecoFactory(request);
            candidatoRepository.save(candidato);
            return new CandidatoDto(candidato);
        }).orElseThrow(() -> new NotFoundException("cpf not found"));
    }

    public List<CandidatoDto> getAll(){
       return candidatoRepository.findAll().stream()
               .filter(Candidato::isStatus)
               .map(CandidatoDto::new)
               .collect(Collectors.toList());
    }

    public boolean delete(String cpf) {
         return candidatoRepository.findByCpf(cpf).map(candidato -> {
            candidato.setStatus(false);
            return true;
         }).orElse(false);
    }

    public CandidatoDto getByCpf(String cpf) {
        return candidatoRepository.findByCpf(cpf)
                .map(CandidatoDto::new)
                .orElseThrow(() -> new NotFoundException("Candidato não existe"));
    }

    private Candidato enderecoFactory(CandidatoDto candidatoDto){
        Endereco endereco = enderecoService
                .findEndereco(candidatoDto.getEndereco());

        Candidato candidato = candidatoDto.toCandidato();

        candidato.setEndereco(endereco);

        return candidato;
    }
}
