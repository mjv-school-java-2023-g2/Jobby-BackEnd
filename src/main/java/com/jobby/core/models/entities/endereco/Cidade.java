package com.jobby.core.models.entities.endereco;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Table(name = "tb_cidade")
@Entity
public class Cidade {
    @Id
    private Integer id;
    private String nome;
    private String estado;
    private String sigla;

}
