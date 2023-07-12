package com.jobby.core.repositories.endereco;

import com.jobby.core.models.entities.endereco.Cidade;
import com.jobby.core.models.entities.endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

    Optional<Cidade> findById(Integer id);

}
