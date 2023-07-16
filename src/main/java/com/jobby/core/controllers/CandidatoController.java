package com.jobby.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/candidatos")
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    @Autowired
    public CandidatoController(CandidatoService candidatoService) {
        this.candidatoService = candidatoService;
    }
    
    @Autowired
    private CandidatoRepository repository;
    
    @PostMapping
    public ResponseEntity<Void> post(@RequestBody Candidato request) {
        boolean saved = candidatoService.save(request);
        if (saved) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
   
    @PutMapping("/{id}")
    public void put(@PathVariable("id") Integer id, @RequestBody Candidato request){
        candidatoService.update(id,request);
    }
    
    @GetMapping("/all")
    public List<Candidato> getAll(){
        return repository.findAll();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidato(@PathVariable("id") Long id) {
        boolean deleted = candidatoService.deleteCandidato(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}