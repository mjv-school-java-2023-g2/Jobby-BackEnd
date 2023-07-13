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
@Table(name = "tb_endereco")
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Cidade cidade;
}
