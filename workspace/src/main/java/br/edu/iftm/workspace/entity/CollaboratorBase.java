package br.edu.iftm.workspace.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@Document(collection = "collaboratorBase")
public class CollaboratorBase {

    @Id
    private String id;
    private User user;
}
