package br.edu.iftm.base.controller;

import br.edu.iftm.base.entity.Base;
import br.edu.iftm.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/base")
public class BaseController {

    @Autowired
    private BaseService baseService;

    @GetMapping("/{id}")
    public ResponseEntity<Base> findById(@PathVariable String id) {
        return new ResponseEntity<>(baseService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Base> save (@RequestBody Base base) {
        return new ResponseEntity<>(baseService.save(base), HttpStatus.OK);
    }
}
