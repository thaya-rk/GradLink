package com.example.gradlink.controller;

import com.example.gradlink.entity.TPO;
import com.example.gradlink.service.TPOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tpos")
public class TPOController {

    private final TPOService tpoService;

    @Autowired
    public TPOController(TPOService tpoService) {
        this.tpoService = tpoService;
    }

    @PostMapping
    public ResponseEntity<TPO> createTPO(@RequestBody TPO tpo) {
        TPO createdTPO = tpoService.saveTPO(tpo);
        return new ResponseEntity<>(createdTPO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TPO> updateTPO(@PathVariable Long id, @RequestBody TPO tpo) {
        TPO updatedTPO = tpoService.updateTPO(id, tpo);
        return updatedTPO != null ?
                new ResponseEntity<>(updatedTPO, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TPO> getTPOById(@PathVariable Long id) {
        Optional<TPO> tpo = tpoService.getTPOById(id);
        return tpo.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<TPO>> getAllTPOs() {
        List<TPO> tpos = tpoService.getAllTPOs();
        return tpos.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(tpos, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTPO(@PathVariable Long id) {
        tpoService.deleteTPO(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
