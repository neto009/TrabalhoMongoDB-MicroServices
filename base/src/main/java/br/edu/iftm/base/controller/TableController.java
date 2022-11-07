package br.edu.iftm.base.controller;

import br.edu.iftm.base.entity.Table;
import br.edu.iftm.base.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("table")
public class TableController {

    @Autowired
    private TableService tableService;

    @GetMapping("/{id}")
    public ResponseEntity<Table> findById(@PathVariable String id) {
        return new ResponseEntity<>(tableService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save () {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
