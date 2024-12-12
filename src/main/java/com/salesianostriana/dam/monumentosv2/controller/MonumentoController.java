package com.salesianostriana.dam.monumentosv2.controller;

import com.salesianostriana.dam.monumentosv2.model.Monumento;
import com.salesianostriana.dam.monumentosv2.repository.MonumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monumento/")
@RequiredArgsConstructor
public class MonumentoController {

    private final MonumentoRepository monumentoRepository;

    @PostMapping
    public ResponseEntity<Monumento> create(@RequestBody Monumento monumento) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(monumentoRepository.add(monumento));
    }

    @GetMapping
    public ResponseEntity<List<Monumento>> getAll() {
        List<Monumento> result = monumentoRepository.getAll();

        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Monumento> getById(@PathVariable Long id) {
        return ResponseEntity.of(
                monumentoRepository.get(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Monumento> edit(@PathVariable("id") Long id, @RequestBody Monumento monumento) {
        return ResponseEntity.of(
                monumentoRepository.edit(id, monumento)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        monumentoRepository.delete(id);
        return ResponseEntity.noContent().build();
    }

}
