package com.jobby.core.models.entities.candidato;



import com.jobby.core.models.entities.candidato.experiencia.Profissao;
import com.jobby.core.models.entities.endereco.Endereco;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.jobby.core.models.enuns.Sexo;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Candidato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 100, message = "Nome não pode exceder 100 caracteres")
    @Column(name = "nome")
    private String nome;
    @NotBlank(message = "CPF é obrigatório")
    @CPF
    @Column(name = "cpf")
    private String cpf;
    @Past(message = "A data de nascimento precisa ser no passado")
    @DateTimeFormat(pattern = "yyyy-dd-MM")
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    @NotBlank(message = "O e-mail é obrigatório")
    @Email(message = "Formato de e-mail inválido")
    @Column(name = "email")
    private String email;
    @Embedded
    private Telefone telefone;
    @Column(name = "sexo")
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    @Column(name = "status")
    private boolean status = true;
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    @Embedded
    private PretencaoSalarial pretencaoSalarial;
    @ManyToOne(cascade = CascadeType.ALL)
    private Profissao profissao;
    @Column(name = "habilidades")
    @CollectionTable(name = "candidato_habilidades", joinColumns = @JoinColumn(name = "candidato_id"))
    @ElementCollection(fetch = FetchType.LAZY)
    private Set<String> habilidades;
}
