package com.jobby.core.services;

import com.jobby.core.exceptions.NotFoundException;
import com.jobby.core.models.entities.candidato.experiencia.Profissao;
import com.jobby.core.models.requests.ExperienciaRequest;
import com.jobby.core.models.entities.candidato.experiencia.Experiencia;
import com.jobby.core.models.requests.ProfissaoRequest;
import com.jobby.core.models.responses.ExperienciaResponse;
import com.jobby.core.repositories.persistence.CandidatoRepository;
import com.jobby.core.repositories.persistence.ExperienciaRepository;
import com.jobby.core.repositories.persistence.ProfissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExperienciaService {

    @Autowired
    ExperienciaRepository experienciaRepository;
    @Autowired
    CandidatoRepository candidatoRepository;
    @Autowired
    ProfissaoRepository profissaoRepository;

    public ExperienciaResponse add(ExperienciaRequest experienciaRequest){

        if (candidatoRepository.findById(experienciaRequest.getCandidatoId()).isEmpty()) {
            throw new IllegalArgumentException();
        }
        Profissao profissao = findProfissao(experienciaRequest.getProfissao());

        Experiencia experiencia = experienciaRequest.toExperiencia();

        experiencia.setProfissao(profissao);

        return new ExperienciaResponse(experienciaRepository.save(experiencia));
    }

    public ExperienciaResponse update(ExperienciaRequest experienciaRequest, Integer id) {
        return new ExperienciaResponse(experienciaRepository
                .findById(id).map(experiencia -> {
                    experiencia = experienciaRequest.toExperiencia();
                    experienciaRepository.save(experiencia);
                    return experiencia;
                }).orElseThrow(() -> new NotFoundException("experiencia not found"))
        );

    }

    public List<ExperienciaResponse> delete(Integer candidatoId, Integer experienciaId) {
        experienciaRepository.deleteById(experienciaId);
        return getExperiencias(candidatoId);
    }

    public List<ExperienciaResponse> getAllById(Integer id) {
       return getExperiencias(id);
    }

    private List<ExperienciaResponse> getExperiencias(Integer candidatoId){
        return experienciaRepository.findAllByCandidatoId(candidatoId)
                .stream()
                .map(ExperienciaResponse::new)
                .collect(Collectors.toList());
    }

    private Profissao findProfissao(Profissao profissao){
        return profissaoRepository.findByNome(profissao.getNome())
                .orElse(profissao);
    }
}
