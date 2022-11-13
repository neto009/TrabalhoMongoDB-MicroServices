package br.edu.iftm.workspace.service;

import br.edu.iftm.workspace.dto.Access;
import br.edu.iftm.workspace.dto.WorkspaceForm;
import br.edu.iftm.workspace.entity.Base;
import br.edu.iftm.workspace.entity.Collaborator;
import br.edu.iftm.workspace.entity.User;
import br.edu.iftm.workspace.entity.Workspace;
import br.edu.iftm.workspace.exception.WorkspaceNotFoundException;
import br.edu.iftm.workspace.message.Message;
import br.edu.iftm.workspace.message.dto.MessageDTO;
import br.edu.iftm.workspace.repository.BaseRepository;
import br.edu.iftm.workspace.repository.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
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

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private Message message;

    public List<Workspace> findAll() {
        return workspaceRepository.findAll();
    }

    public Workspace findById(String id) {
        return workspaceRepository.findById(id).orElseThrow(() -> new WorkspaceNotFoundException("Workspace no Exist!"));
    }

    public Workspace save(WorkspaceForm workspaceForm) {
        List<Base> baseList = new ArrayList<>();
        List<Collaborator> collaboratorList = new ArrayList<>();
        User user = userService.findById(workspaceForm.getUserId());
        Collaborator collaborator = new Collaborator(user, Access.OWNER);
        collaboratorList.add(collaborator);
        Workspace workspace = workspaceRepository.save(new Workspace(workspaceForm.getName(), collaboratorList, baseList));
        message.sendMessage(new MessageDTO(workspace.getId(), workspace.getName(), user.getId(), Access.OWNER.toString()));
        return workspace;
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
