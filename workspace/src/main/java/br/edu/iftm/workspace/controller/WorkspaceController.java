package br.edu.iftm.workspace.controller;

import br.edu.iftm.workspace.entity.Workspace;
import br.edu.iftm.workspace.service.WorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("workspace")
public class WorkspaceController {

    @Autowired
    private WorkspaceService workspaceService;

    @GetMapping
    public ResponseEntity<List<Workspace>> findAll() {
        List<Workspace> workspaces = workspaceService.findAll();
        return new ResponseEntity<>(workspaces, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        workspaceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
