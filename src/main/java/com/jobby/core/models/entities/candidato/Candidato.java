package com.jobby.core.models.entities.candidato;

import com.jobby.core.models.entities.endereco.Endereco;
import com.jobby.core.models.entities.pretencao_salarial.PretencaoSalarial;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
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

    @NotEmpty(message = "Nome é obrigatório")
    @Size(max = 100, message = "Nome não pode exceder 100 caracteres")
    private String nome;

    @NotEmpty(message = "CPF é obrigatório")
    @Size(min = 11, max = 11, message = "CPF deve conter exatamente 11 caracteres numéricos")
    private String cpf;

    @Past(message = "A data de nascimento precisa ser no passado")
    private LocalDate nascimento;

    // TODO: telefone

    @NotEmpty(message = "O e-mail é obrigatório")
    @Email(message = "Formato de e-mail inválido")
    private String email;

    // TODO: SexoEnum
    
    @ManyToOne(cascade = CascadeType.MERGE)
    private Endereco endereco;

    @Embedded
    private PretencaoSalarial pretencaoSalarial;
}
