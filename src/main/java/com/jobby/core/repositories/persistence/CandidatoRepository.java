package com.jobby.core.repositories.persistence;

import com.jobby.core.models.entities.candidato.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidatoRepository extends JpaRepository<Candidato, Integer> {

    Optional<Candidato> findByCpf(String cpf);
}
