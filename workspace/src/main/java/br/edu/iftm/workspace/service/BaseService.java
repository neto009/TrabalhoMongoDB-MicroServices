package br.edu.iftm.workspace.service;

import br.edu.iftm.workspace.dto.Access;
import br.edu.iftm.workspace.dto.BaseForm;
import br.edu.iftm.workspace.entity.*;
import br.edu.iftm.workspace.feign.BaseFeign;
import br.edu.iftm.workspace.feign.feignDTO.BaseFeignForm;
import br.edu.iftm.workspace.message.Message;
import br.edu.iftm.workspace.message.dto.MessageDTO;
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

    @Autowired
    private Message message;

    public Base findById(String id) {
        return baseRepository.findById(id).orElseThrow(()-> new RuntimeException("No Exist"));
    }

    public Base save(BaseForm baseForm) {
        Workspace workspace = workspaceService.findById(baseForm.getWorkspaceId());
        List<Collaborator> collaboratorList = new ArrayList<>();
        User user = userService.findById(baseForm.getUserId());
        Optional<Collaborator> owner = workspace.getCollaboratorList().stream()
                .filter(colab-> colab.getUser().getId().equals(baseForm.getUserId())).findFirst();
        if(!owner.isPresent()){
            Collaborator collaborator = new Collaborator(user, Access.OWNER);
            collaboratorList.add(collaborator);
        }
        Base base = new Base(baseForm.getName(), collaboratorList);
        Base currentBase = baseRepository.save(base);
        List<Base> baseList = workspace.getBases();
        baseList.add(currentBase);
        workspace.setBases(baseList);
        workspaceService.update(workspace);
        baseFeign.saveBase(new BaseFeignForm(currentBase.getId(), currentBase.getName()));
        message.sendMessage(new MessageDTO(currentBase.getId(), currentBase.getName(), user.getId(), Access.OWNER.toString()));
        return currentBase;
    }

    public void delete(String id) {
        baseRepository.deleteById(id);
    }
}
