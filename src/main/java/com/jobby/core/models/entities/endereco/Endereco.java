package com.jobby.core.models.entities.endereco;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank
    private String cep;
    private String logradouro;
    @NotBlank
    private String numero;
    @NotBlank
    private String complemento;
    private String bairro;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Cidade cidade;
}
