package com.jobby.core;

import com.jobby.core.models.dtos.CandidatoDto;
import com.jobby.core.models.entities.candidato.Candidato;
import com.jobby.core.services.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CandidatoController {

    @Autowired
    CandidatoService candidatoService;

    @PostMapping("/jobby/v1/candidatos")
    public ResponseEntity<Candidato> saveCandidato(@RequestBody CandidatoDto CandidatoDto){
        return ResponseEntity.ok(candidatoService.saveCandidato(CandidatoDto));
    }
}
