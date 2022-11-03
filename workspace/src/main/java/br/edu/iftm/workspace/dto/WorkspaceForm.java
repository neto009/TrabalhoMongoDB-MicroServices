package br.edu.iftm.workspace.dto;

import br.edu.iftm.workspace.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WorkspaceForm {
    private String name;
    private String userId;
}
