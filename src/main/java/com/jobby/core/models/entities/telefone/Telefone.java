package com.jobby.core.models.entities.telefone;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Telefone {
    private Long numero;
    private boolean isWhatsapp;
}
