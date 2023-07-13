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
@Table(name = "tb_cidade")
@Entity
public class Cidade {
    @Id
    private Integer id;
    private String nome;
    private String estado;
    private String sigla;

}
