package com.jobby.core.models.dtos;

import com.jobby.core.models.entities.candidato.Candidato;
import com.jobby.core.models.entities.candidato.PretencaoSalarial;
import com.jobby.core.models.entities.candidato.Telefone;
import com.jobby.core.models.entities.candidato.experiencia.Profissao;
import com.jobby.core.models.enuns.Sexo;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.util.Set;

@Builder
@Data
public class CandidatoDto {
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private Telefone telefone;
    private Sexo sexo;
    private EnderecoDto endereco;
    private PretencaoSalarial pretencaoSalarial;
    private Profissao profissao;
    private Set<String> habilidades;
    public Candidato toCandidato(){
        Candidato candidato = new Candidato();
        BeanUtils.copyProperties(this, candidato);
        return candidato;
    }
}
