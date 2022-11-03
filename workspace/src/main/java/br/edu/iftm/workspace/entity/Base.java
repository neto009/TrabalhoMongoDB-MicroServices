package br.edu.iftm.workspace.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "base")
public class Base {

    @Id
    private String id;
    private String name;
    private List<CollaboratorBase> collaboratorBaseList;

    public Base (String name, List<CollaboratorBase> collaboratorBaseList){
        this.name = name;
        this.collaboratorBaseList = collaboratorBaseList;
    }
}
