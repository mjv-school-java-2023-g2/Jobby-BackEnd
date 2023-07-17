package com.jobby.core.repositories.persistence;

import com.jobby.core.models.entities.candidato.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CandidatoRepository extends JpaRepository<Candidato, Integer> {

    Optional<Candidato> findByCpf(String cpf);

    @Query(value = "SELECT DISTINCT c " +
            "FROM Candidato c " +
            "INNER JOIN Experiencia e ON c.id = e.candidatoId " +
            "INNER JOIN e.profissao p " +
            "WHERE p.nome = :nomeProfissao " +
            "GROUP BY c.id " +
            "HAVING SUM(EXTRACT(YEAR FROM e.dataDesligamento) - EXTRACT(YEAR FROM e.dataEntrada)) > :anosExperiencia")
    List<Candidato> findCandidatosByCargoAndExperiencia(
            @Param("nomeProfissao") String nomeProfissao,
            @Param("anosExperiencia") int anosExperiencia);
}
