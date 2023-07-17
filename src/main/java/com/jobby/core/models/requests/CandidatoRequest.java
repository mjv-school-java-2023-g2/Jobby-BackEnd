package com.jobby.core.models.requests;

import com.jobby.core.models.entities.candidato.Candidato;
import com.jobby.core.models.entities.candidato.PretencaoSalarial;
import com.jobby.core.models.entities.candidato.Telefone;
import com.jobby.core.models.entities.candidato.experiencia.Profissao;
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
public class CandidatoRequest {
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private Telefone telefone;
    private Sexo sexo;
    private boolean status;
    private EnderecoRequest endereco;
    private PretencaoSalarial pretencaoSalarial;
    private Profissao profissao;
    private Set<String> habilidades;

    public CandidatoRequest(Candidato candidato){
        BeanUtils.copyProperties(candidato, this);
    }
    public Candidato toCandidato(){
        Candidato candidato = new Candidato();
        BeanUtils.copyProperties(this, candidato);
        return candidato;
    }
}
