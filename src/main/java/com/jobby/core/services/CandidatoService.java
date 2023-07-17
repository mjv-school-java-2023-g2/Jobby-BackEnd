package com.jobby.core.services;

import com.jobby.core.exceptions.NotFoundException;
import com.jobby.core.models.requests.CandidatoRequest;
import com.jobby.core.models.entities.candidato.Candidato;
import com.jobby.core.models.entities.endereco.Endereco;
import com.jobby.core.models.responses.CandidatoResponse;
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

    public CandidatoResponse save(CandidatoRequest candidatoRequest){

        if (candidatoRepository.
                findByCpf(candidatoRequest.getCpf()).isPresent()) {
            throw new IllegalArgumentException();
        }

        Candidato candidato = enderecoFactory(candidatoRequest);

        candidatoRepository.save(candidato);

        return new CandidatoResponse(candidato);
    }

    public CandidatoResponse update(String cpf, CandidatoRequest request) {
       return candidatoRepository.findByCpf(cpf).map( candidato -> {
            candidato = enderecoFactory(request);
            candidatoRepository.save(candidato);
            return new CandidatoResponse(candidato);
        }).orElseThrow(() -> new NotFoundException("cpf not found"));
    }

    public List<CandidatoResponse> getAll(){
       return candidatoRepository.findAll().stream()
               .filter(Candidato::isStatus)
               .map(CandidatoResponse::new)
               .collect(Collectors.toList());
    }

    public boolean delete(String cpf) {
         return candidatoRepository.findByCpf(cpf).map(candidato -> {
            candidato.setStatus(false);
            return true;
         }).orElse(false);
    }

    public CandidatoResponse getByCpf(String cpf) {
        return candidatoRepository.findByCpf(cpf)
                .map(CandidatoResponse::new)
                .orElseThrow(() -> new NotFoundException("Candidato não existe"));
    }

    public List<CandidatoResponse> getByCidade(String cidade) {
        return candidatoRepository.findAllByCidade(cidade)
                .stream().map(CandidatoResponse::new)
                .toList();
    }

    public List<CandidatoResponse> getByExperienciaAndCargo(String profissao, Integer anos) {
        return candidatoRepository
                .findCandidatosByCargoAndExperiencia(profissao, anos)
                .stream().map(CandidatoResponse::new)
                .toList();
    }
    private Candidato enderecoFactory(CandidatoRequest candidatoRequest){
        Endereco endereco = enderecoService
                .findEndereco(candidatoRequest.getEndereco());
        Candidato candidato = candidatoRequest.toCandidato();

        candidato.setEndereco(endereco);

        return candidato;
    }
}
