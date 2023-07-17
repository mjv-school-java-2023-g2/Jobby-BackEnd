package com.jobby.core.models.responses;

import com.jobby.core.models.entities.candidato.Candidato;
import com.jobby.core.models.entities.candidato.PretencaoSalarial;
import com.jobby.core.models.entities.candidato.Telefone;
import com.jobby.core.models.enuns.Sexo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CandidatoResponse {
    private Integer id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private Telefone telefone;
    private Sexo sexo;
    private EnderecoResponse endereco;
    private PretencaoSalarial pretencaoSalarial;
    private ProfissaoResponse profissao;
    private Set<String> habilidades;

    public CandidatoResponse(Candidato candidato) {
        this.endereco = new EnderecoResponse(candidato.getEndereco());
        this.profissao = new ProfissaoResponse(candidato.getProfissao());
        BeanUtils.copyProperties(candidato, this);
    }
}
