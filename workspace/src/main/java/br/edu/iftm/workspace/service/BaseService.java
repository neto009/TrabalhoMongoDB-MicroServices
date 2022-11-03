package br.edu.iftm.workspace.service;

import br.edu.iftm.workspace.dto.Access;
import br.edu.iftm.workspace.dto.BaseForm;
import br.edu.iftm.workspace.entity.*;
import br.edu.iftm.workspace.feign.BaseFeign;
import br.edu.iftm.workspace.feign.feignDTO.BaseFeignForm;
import br.edu.iftm.workspace.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BaseService {

    @Autowired
    private BaseRepository baseRepository;

    @Autowired
    private WorkspaceService workspaceService;

    @Autowired
    private UserService userService;

    @Autowired
    private BaseFeign baseFeign;

    public Base findById(String id) {
        return baseRepository.findById(id).orElseThrow(()-> new RuntimeException("No Exist"));
    }

    public Base save(BaseForm baseForm) {
        Workspace workspace = workspaceService.findById(baseForm.getWorkspaceId());
        List<CollaboratorBase> collaboratorBaseList = new ArrayList<>();
        User user = userService.findById(baseForm.getUserId());
        Optional<CollaboratorWorkspace> owner = workspace.getCollaboratorWorkspaceList().stream()
                .filter(colab-> colab.getUser().getId().equals(baseForm.getUserId())).findFirst();
        if(!owner.isPresent()){
            CollaboratorBase collaboratorBase = new CollaboratorBase(user, Access.OWNER);
            collaboratorBaseList.add(collaboratorBase);
        }
        Base base = new Base(baseForm.getName(), collaboratorBaseList);
        Base currentBase = baseRepository.save(base);
        List<Base> baseList = workspace.getBases();
        baseList.add(currentBase);
        workspace.setBases(baseList);
        workspaceService.update(workspace);
        BaseFeignForm baseFeignForm = baseFeign.saveBase(new BaseFeignForm(currentBase.getId(), currentBase.getName()));
        return currentBase;
    }

    public void delete(String id) {
        baseRepository.deleteById(id);
    }
}
