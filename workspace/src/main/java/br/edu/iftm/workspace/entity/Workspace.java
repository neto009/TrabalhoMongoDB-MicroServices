package br.edu.iftm.workspace.entity;

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
    private List<Collaborator> collaboratorList;
    @DBRef(lazy = true)
    private List<Base> bases;

    public Workspace (String name, List<Collaborator> collaboratorList, List<Base> bases) {
        this.name = name;
        this.collaboratorList = collaboratorList;
        this.bases = bases;
    }
}
