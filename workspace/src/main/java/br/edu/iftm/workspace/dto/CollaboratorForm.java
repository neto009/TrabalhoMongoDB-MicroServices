package br.edu.iftm.workspace.dto;

import br.edu.iftm.workspace.enums.Access;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CollaboratorForm {
    private String spaceId;
    private String userId;
    private Access access;

    public CollaboratorForm( String spaceId, String userId){
        this.spaceId = spaceId;
        this.userId = userId;
    }
}
