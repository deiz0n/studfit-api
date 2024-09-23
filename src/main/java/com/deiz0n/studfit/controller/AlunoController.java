package com.deiz0n.studfit.controller;

import com.deiz0n.studfit.domain.dtos.AlunoDTO;
import com.deiz0n.studfit.domain.dtos.AlunoListaEsperaDTO;
import com.deiz0n.studfit.domain.response.ResponseRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.UUID;

public interface AlunoController {

    @GetMapping("lista-espera")
    ResponseEntity<ResponseRequest> getAlunosListaEspera(ServletWebRequest path);

    @PostMapping("/lista-espera/register")
    ResponseEntity<ResponseRequest> registerAlunoListaEspera(@RequestBody @Valid AlunoListaEsperaDTO request, ServletWebRequest path);

    @DeleteMapping("/lista-espera/delete/{id}")
    ResponseEntity removeAlunoListaEspera(@PathVariable UUID id, ServletWebRequest path);

    @GetMapping("efetivados")
    ResponseEntity<ResponseRequest> getAlunosEfetivados(ServletWebRequest path);

    @PatchMapping("efetivados/efetivar")
    ResponseEntity<ResponseRequest> registerAlunoEfetivado(@RequestBody @Valid AlunoDTO request, ServletWebRequest path);

    @DeleteMapping("efetivados/delete/{id}")
    ResponseEntity removeAlunoEfetivado(@PathVariable UUID id);

    @PatchMapping("efetivado/update/{id}")
    ResponseEntity<ResponseRequest> updateAlunoEfetivado(@PathVariable UUID id, @RequestBody @Valid AlunoDTO request, ServletWebRequest path);
}
