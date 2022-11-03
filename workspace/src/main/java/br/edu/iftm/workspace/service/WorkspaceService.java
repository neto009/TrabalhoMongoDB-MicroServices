package br.edu.iftm.workspace.service;

import br.edu.iftm.workspace.dto.Access;
import br.edu.iftm.workspace.dto.WorkspaceForm;
import br.edu.iftm.workspace.entity.Base;
import br.edu.iftm.workspace.entity.CollaboratorWorkspace;
import br.edu.iftm.workspace.entity.User;
import br.edu.iftm.workspace.entity.Workspace;
import br.edu.iftm.workspace.repository.BaseRepository;
import br.edu.iftm.workspace.repository.WorkspaceRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkspaceService {

    @Autowired
    private WorkspaceRepository workspaceRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private BaseRepository baseRepository;

    public List<Workspace> findAll() {
        return workspaceRepository.findAll();
    }

    public Workspace findById(String id) {
        return workspaceRepository.findById(id).orElseThrow(() -> new RuntimeException("No Exist"));
    }

    public Workspace save(WorkspaceForm workspaceForm) {
        List<Base> baseList = new ArrayList<>();
        List<CollaboratorWorkspace> collaboratorWorkspaceList = new ArrayList<>();
        User user = userService.findById(workspaceForm.getUserId());
        CollaboratorWorkspace collaboratorWorkspace = new CollaboratorWorkspace(user, Access.OWNER);
        collaboratorWorkspaceList.add(collaboratorWorkspace);
        Workspace workspace = new Workspace(workspaceForm.getName(), collaboratorWorkspaceList, baseList);
        return workspaceRepository.save(workspace);
    }

    public Workspace update(Workspace workspace) {
        return workspaceRepository.save(workspace);
    }

    public void delete(String id) {
        Workspace workspace = this.findById(id);
        workspace.getBases().parallelStream().forEach(base -> baseRepository.deleteById(base.getId()));
        workspaceRepository.deleteById(id);
    }
}
