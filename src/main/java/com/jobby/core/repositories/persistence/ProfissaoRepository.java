package com.jobby.core.repositories.persistence;

import com.jobby.core.models.entities.candidato.experiencia.Profissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProfissaoRepository extends JpaRepository<Profissao, Integer> {
    Optional<Profissao> findByNome(String nome);

}
