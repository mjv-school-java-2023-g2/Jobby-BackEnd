package com.jobby.core.controllers;

import java.net.URI;
import java.util.List;

import com.jobby.core.models.requests.CandidatoRequest;
import com.jobby.core.models.responses.CandidatoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jobby.core.services.CandidatoService;

@RestController
@RequestMapping("jobby/v1/candidatos")
public class CandidatoController {
    @Autowired
    private CandidatoService candidatoService;

    @PostMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> post(@RequestBody CandidatoRequest request, URI uri) {
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
    public ResponseEntity<CandidatoResponse> put(@PathVariable("cpf") String cpf,
                                            @RequestBody CandidatoRequest request
    ){

        CandidatoResponse response = candidatoService.update(cpf,request);

        return ResponseEntity.ok().body(response);
    }
    
    @GetMapping
    public ResponseEntity<List<CandidatoResponse>> getAll(){

        List<CandidatoResponse> response = candidatoService.getAll();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<CandidatoResponse> getCandidatoByCpf(@PathVariable("cpf") String cpf){

        CandidatoResponse response = candidatoService.getByCpf(cpf);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/filters")
    public ResponseEntity<List<CandidatoResponse>> getCandidatoByCpf(
            @RequestParam("cargo") String cargo,
            @RequestParam("tempo") Integer tempo
    ){
        List<CandidatoResponse> response = candidatoService
                .getByExperienciaAndCargo(cargo, tempo);

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