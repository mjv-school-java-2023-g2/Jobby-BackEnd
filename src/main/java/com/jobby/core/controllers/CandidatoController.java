package com.jobby.core.controllers;

import java.net.URI;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.jobby.core.models.dtos.CandidatoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobby.core.models.entities.candidato.Candidato;
import com.jobby.core.models.entities.candidato.experiencia.Profissao;
import com.jobby.core.repositories.persistence.CandidatoRepository;
import com.jobby.core.services.CandidatoService;

@RestController
@RequestMapping("jobby/v1/candidatos")
public class CandidatoController {
    @Autowired
    private CandidatoService candidatoService;

    @PostMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> post(@RequestBody CandidatoDto request, URI uri) {
        if (candidatoService.saveCandidato(request) != null) {
            return ResponseEntity
                    .created(uri)
                    .body("""
                            {
                              "mensagem": "criado com sucesso"
                            }
                            """);
        } else {
            return ResponseEntity
                    .badRequest()
                    .build();
        }
    }
   
    @PutMapping("/{cpf}")
    public ResponseEntity<CandidatoDto> put(@PathVariable("cpf") String cpf, @RequestBody CandidatoDto request){
        return ResponseEntity
                .ok()
                .body(candidatoService.update(cpf,request));
    }
    
    @GetMapping
    public ResponseEntity<List<CandidatoDto>> getAll(){
        return ResponseEntity.ok(candidatoService.getAll());
    }
    
    @DeleteMapping(value = "/{cpf}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteCandidato(@PathVariable("cpf") String cpf) {
        if (candidatoService.delete(cpf)) {
            return ResponseEntity.ok(
                    """
                           {
                             "mensagem": "removido com sucesso"
                           }
                          """);
        }
        return ResponseEntity.badRequest().build();
    }
}