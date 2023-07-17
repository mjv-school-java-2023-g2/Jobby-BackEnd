package com.jobby.core.repositories.persistence;

import com.jobby.core.models.entities.candidato.Candidato;
import com.jobby.core.models.entities.candidato.experiencia.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExperienciaRepository extends JpaRepository<Experiencia, Integer> {
    Optional<Experiencia> findByCandidatoId(Integer candidatoId);

    List<Experiencia> findAllByCandidatoId(Integer candidatoId);

}
