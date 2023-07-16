package com.jobby.core.models.entities.endereco;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cidade {
    @Id
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "estado")
    private String estado;
    @Column(name = "sigla")
    private String sigla;
}
