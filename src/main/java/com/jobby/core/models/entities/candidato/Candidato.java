package com.jobby.core.models.entities.candidato;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Candidato {
    @Id
    Integer id;
}
