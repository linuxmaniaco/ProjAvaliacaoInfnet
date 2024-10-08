package com.example.ProjAvaliacaoInfnet.controller;

import com.example.ProjAvaliacaoInfnet.model.Avaliacao;
import com.example.ProjAvaliacaoInfnet.service.AvaliacaoService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@Slf4j
@RequiredArgsConstructor
public class AvaliacaoController {
    private final AvaliacaoService avaliacaoService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getAvaliacao(@PathVariable Long id) {
        log.info("Avaliacao ID: {}", id);
        List<Avaliacao> allByProdutoId = avaliacaoService.getAllByProdutoId(id);
        if (allByProdutoId.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(allByProdutoId);
        }
    }
}
