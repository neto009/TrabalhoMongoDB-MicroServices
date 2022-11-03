package br.edu.iftm.workspace.entity;

import br.edu.iftm.workspace.dto.Access;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollaboratorBase {

    private User user;
    private Access access;
}
