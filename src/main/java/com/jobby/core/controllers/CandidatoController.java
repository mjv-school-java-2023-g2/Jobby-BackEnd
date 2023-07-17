package com.jobby.core.controllers;

import java.net.URI;
import java.util.List;

import com.jobby.core.models.dtos.CandidatoDto;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.jobby.core.services.CandidatoService;

@RestController
@RequestMapping("jobby/v1/candidatos")
public class CandidatoController {
    @Autowired
    private CandidatoService candidatoService;

    @PostMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> post(@RequestBody CandidatoDto request, URI uri) {
        if (candidatoService.save(request) != null) {
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
    public ResponseEntity<CandidatoDto> put(@PathVariable("cpf") String cpf,
                                            @RequestBody CandidatoDto request
    ){

        CandidatoDto response = candidatoService.update(cpf,request);

        return ResponseEntity.ok().body(response);
    }
    
    @GetMapping
    public ResponseEntity<List<CandidatoDto>> getAll(){

        List<CandidatoDto> response = candidatoService.getAll();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<CandidatoDto> getCandidatoByCpf(@PathVariable("cpf") String cpf){

        CandidatoDto response = candidatoService.getByCpf(cpf);

        return ResponseEntity.ok(response);
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