package com.jobby.core.models.entities.candidato;

import com.jobby.core.models.entities.endereco.Endereco;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_candidato")
@Entity
public class Candidato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Endereco endereco;
}
