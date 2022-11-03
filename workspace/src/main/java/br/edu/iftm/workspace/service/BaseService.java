package br.edu.iftm.workspace.service;

import br.edu.iftm.workspace.dto.Access;
import br.edu.iftm.workspace.dto.BaseForm;
import br.edu.iftm.workspace.entity.Base;
import br.edu.iftm.workspace.entity.CollaboratorBase;
import br.edu.iftm.workspace.entity.User;
import br.edu.iftm.workspace.entity.Workspace;
import br.edu.iftm.workspace.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BaseService {

    @Autowired
    private BaseRepository baseRepository;

    @Autowired
    private WorkspaceService workspaceService;

    @Autowired
    private UserService userService;

    public Base findById(String id) {
        return baseRepository.findById(id).orElseThrow(()-> new RuntimeException("No Exist"));
    }

    public Base save(BaseForm baseForm) {
        Workspace workspace = workspaceService.findById(baseForm.getWorkspaceId());
        List<CollaboratorBase> collaboratorBaseList = new ArrayList<>();
        User user = userService.findById(baseForm.getUserId());
        User owner = workspace.getCollaboratorWorkspaceList().stream()
                .filter(colab-> colab.getUser().getId().equals(baseForm.getUserId())).findAny().get().getUser();
        if(owner == null){
            CollaboratorBase collaboratorBase = new CollaboratorBase(user, Access.OWNER);
            collaboratorBaseList.add(collaboratorBase);
        }
        Base base = new Base(baseForm.getName(), collaboratorBaseList);
        Base currentBase = baseRepository.save(base);
        List<Base> baseList = workspace.getBases();
        baseList.add(currentBase);
        workspace.setBases(baseList);
        workspaceService.update(workspace);
        return currentBase;
    }

    public void delete(String id) {
        baseRepository.deleteById(id);
    }
}
