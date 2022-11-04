package br.edu.iftm.workspace.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseForm {
    private String name;
    private String workspaceId;
    private String userId;
}
