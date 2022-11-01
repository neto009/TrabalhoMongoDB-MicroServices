package br.edu.iftm.workspace.service;

import br.edu.iftm.workspace.entity.Workspace;
import br.edu.iftm.workspace.repository.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkspaceService {

    @Autowired
    private WorkspaceRepository workspaceRepository;

    public List<Workspace> findAll() {
        return workspaceRepository.findAll();
    }

    public void delete(String id) {
        workspaceRepository.deleteById(id);
    }
}
