package com.jobby.core.services;

import com.jobby.core.exceptions.NotFoundException;
import com.jobby.core.models.requests.ExperienciaRequest;
import com.jobby.core.models.entities.candidato.experiencia.Experiencia;
import com.jobby.core.models.responses.ExperienciaResponse;
import com.jobby.core.repositories.persistence.CandidatoRepository;
import com.jobby.core.repositories.persistence.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService {

    @Autowired
    ExperienciaRepository experienciaRepository;
    @Autowired
    CandidatoRepository candidatoRepository;

    public ExperienciaResponse add(ExperienciaRequest experienciaRequest){

        if (candidatoRepository.findById(experienciaRequest.getCandidatoId()).isEmpty()) {
            throw new IllegalArgumentException();
        }

        Experiencia experiencia = experienciaRepository
                .save(experienciaRequest.toExperiencia());

        return new ExperienciaResponse(experiencia);
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

    public ExperienciaResponse delete(Integer candidatoId, Integer experienciaId) {
        experienciaRepository.deleteById(experienciaId);
        return getExperiencias(candidatoId);
    }

    public ExperienciaResponse getAllById(Integer id) {
       return getExperiencias(id);
    }

    private ExperienciaResponse getExperiencias(Integer candidatoId){
        return new ExperienciaResponse(
                experienciaRepository.findAllByCandidatoId(candidatoId)
                        .orElseThrow(() -> new NotFoundException("experiencia not found"))
        );
    }
}
