package com.jobby.core.services;

import com.jobby.core.exceptions.NotFoundException;
import com.jobby.core.models.dtos.ExperienciaDto;
import com.jobby.core.models.entities.candidato.experiencia.Experiencia;
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

    public ExperienciaDto add(ExperienciaDto experienciaDto){

        if (candidatoRepository.findById(experienciaDto.getCandidatoId()).isEmpty()) {
            throw new IllegalArgumentException();
        }

        Experiencia experiencia = experienciaRepository
                .save(experienciaDto.toExperiencia());

        return new ExperienciaDto(experiencia);
    }

    public ExperienciaDto update(ExperienciaDto experienciaDto, Integer id) {
        return new ExperienciaDto(experienciaRepository
                .findById(id).map(experiencia -> {
                    experiencia = experienciaDto.toExperiencia();
                    experienciaRepository.save(experiencia);
                    return experiencia;
                }).orElseThrow(() -> new NotFoundException("experiencia not found"))
        );

    }

    public ExperienciaDto delete(Integer candidatoId, Integer experienciaId) {
        experienciaRepository.deleteById(experienciaId);
        return getExperiencias(candidatoId);
    }

    public ExperienciaDto getAllById(Integer id) {
       return getExperiencias(id);
    }

    private ExperienciaDto getExperiencias(Integer candidatoId){
        return new ExperienciaDto(
                experienciaRepository.findAllByCandidatoId(candidatoId)
                        .orElseThrow(() -> new NotFoundException("experiencia not found"))
        );
    }
}
