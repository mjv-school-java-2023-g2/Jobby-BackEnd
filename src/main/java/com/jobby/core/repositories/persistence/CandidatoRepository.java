package com.jobby.core.repositories.persistence;

import com.jobby.core.models.entities.candidato.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatoRepository extends JpaRepository<Candidato, Integer> {
}
