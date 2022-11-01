package br.edu.iftm.workspace.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

@Data
@AllArgsConstructor
@Document(collection = "workspace")
public class Workspace {

    @Id
    private String id;
    private String name;
    private List<CollaboratorWorkspace> collaboratorWorkspaceList;
    @DBRef(lazy = true)
    private List<Base> bases;
}
