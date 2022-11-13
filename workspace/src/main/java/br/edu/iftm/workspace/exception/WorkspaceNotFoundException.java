package br.edu.iftm.workspace.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WorkspaceNotFoundException extends RuntimeException {
    private String message;
}
