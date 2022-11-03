package br.edu.iftm.workspace.dto;

import br.edu.iftm.workspace.entity.CollaboratorBase;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BaseForm {
    private String name;
    private String workspaceId;
    private String userId;
}
