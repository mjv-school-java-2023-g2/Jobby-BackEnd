package com.jobby.core.repositories.persistence;

import com.jobby.core.models.entities.endereco.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
