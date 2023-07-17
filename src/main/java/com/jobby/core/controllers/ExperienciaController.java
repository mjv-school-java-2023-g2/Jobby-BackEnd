package com.jobby.core.controllers;

import com.jobby.core.models.requests.ExperienciaRequest;
import com.jobby.core.models.responses.ExperienciaResponse;
import com.jobby.core.services.ExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("jobby/v1/experiencias")
public class ExperienciaController {

    @Autowired
    ExperienciaService experienciaService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addExperiencia(@RequestBody ExperienciaRequest request, URI uri) {
        experienciaService.add(request);

        return ResponseEntity
                .created(uri)
                .body("""
                        {
                          "mensagem": "recurso criado com sucesso"
                        }
                        """
                );
    }

    @GetMapping( "/{id}")
    public ResponseEntity<List<ExperienciaResponse>> getExperienciasById(@PathVariable("id") Integer candidatoId){
        return ResponseEntity.ok(experienciaService.getAllById(candidatoId));
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ExperienciaResponse>> deleteExperiencia(
            @RequestParam("candidatoId") Integer candidatoId,
            @RequestParam("experienciaId") Integer experienciaId
    ){
        List<ExperienciaResponse> response = experienciaService.delete(candidatoId, experienciaId);

        return ResponseEntity.ok(response);
    }

}
