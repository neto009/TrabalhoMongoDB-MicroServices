package br.edu.iftm.workspace.entity;

import br.edu.iftm.workspace.dto.Access;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "workspace")
public class Workspace {

    @Id
    private String id;
    private String name;
    private List<CollaboratorWorkspace> collaboratorWorkspaceList;
    @DBRef(lazy = true)
    private List<Base> bases;

    public Workspace (String name, List<CollaboratorWorkspace> collaboratorWorkspaceList, List<Base> bases) {
        this.name = name;
        this.collaboratorWorkspaceList =collaboratorWorkspaceList;
        this.bases = bases;
    }
}
