package br.edu.iftm.workspace.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

@Data
@AllArgsConstructor
@Document(collection = "base")
public class Base {

    @Id
    private String id;
    private String name;
    private List<CollaboratorBase> collaboratorBaseList;
}
